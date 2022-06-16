package com.hl.hw26.Server.src.main.java;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private String clientNumber;
    private LocalDateTime connectTime;
    private Server server;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private static final String HOST = "localhost";
    private static final int PORT = 3443;
    private Socket clientSocket = null;
    private static int clients_count = 0;
    public ClientHandler(Socket socket, Server server) {
        try {
            clients_count++;
            clientNumber ="Client-"+clients_count;
            connectTime=LocalDateTime.now();
            this.server = server;
            this.clientSocket = socket;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void run() {
        try (InputStream is = clientSocket.getInputStream()){
            while (true) {
                server.sendMessageToAllClients(clientNumber +" успешно подключился");
                break;
            }

            while (true) {
                if (inMessage.hasNext()) {

                    String clientMessage = inMessage.nextLine();
                    if (clientMessage.contains("-file")) {
                        String[] str = clientMessage.split(" ");
                        File file = new File(str[2]);
                        byte[] buffer = new byte[64 * 1024];
                        FileOutputStream fos = new FileOutputStream(
                                "C:\\Users\\Admin\\"+file.getName());
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
                        int bytesRead = is.read(buffer, 0, buffer.length);
                        bos.write(buffer, 0, bytesRead);
                        bos.close();
                    }
                    if (clientMessage.equalsIgnoreCase("-exit"))
                        break;
                    System.out.println(clientMessage);
                    server.sendMessageToAllClients(clientMessage);
                }
                Thread.sleep(100);
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }
    }
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void close() {
        server.removeClient(this);
        clients_count--;
        server.sendMessageToAllClients("Clients number is " + clients_count);
    }
}
