package com.hl.hw26.Server.src.main.java;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerUploader {
    private Scanner inMessage;
    private Socket clientSocket;

    public void upload() {
        try (InputStream is = clientSocket.getInputStream()) {
            String clientMessage = inMessage.nextLine();
            if (clientMessage.contains("-file")) {
                String[] str = clientMessage.split(" ");
                File file = new File(str[2]);
                byte[] buffer = new byte[64 * 1024];
                FileOutputStream fos = new FileOutputStream(
                        "C:\\Users\\Admin\\" + file.getName());
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                int bytesRead = is.read(buffer, 0, buffer.length);
                bos.write(buffer, 0, bytesRead);
                bos.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
