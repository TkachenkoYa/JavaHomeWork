package com.pb.tkachenkoya.hw14;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class client {
    public static class ClientSomthing {
        private Socket socket;
        private static BufferedReader in;
        private static BufferedWriter out;
        private static BufferedReader inputUser;
        private String address;
        private int port;
        private String login;
        private static Date time;
        private static String dtime;
        private static SimpleDateFormat dt1;
                public ClientSomthing(String address, int port) {
            this.address = address;
            this.port = port;
            try {
                this.socket = new Socket(address, port);
            } catch (IOException e) {
                System.err.println("Соединение не удалось");
            }
            try {
                inputUser = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.pressLogin();
                new ReadMsg().start();
                new WriteMsg().start();
            } catch (IOException e) {
                ClientSomthing.this.downService();
            }
        }
        private void pressLogin() {
            System.out.print("Введите логин: ");
            try {
                login = inputUser.readLine();
                out.write("Привет " + login + ", если хотите окончить чат введите слово конец"+"\n");
                out.flush();
            } catch (IOException ignored) {
            }
        }
        private void downService() {
            try {
                if (!socket.isClosed()) {
                    socket.close();
                    in.close();
                    out.close();
                }
            } catch (IOException ignored) {}
        }
        public class ReadMsg extends Thread {
            @Override
            public void run() {
                String str;
                try {
                    while (true) {
                        str = in.readLine();
                        if (str.equals("конец")) {
                            ClientSomthing.this.downService();
                            break;
                        }
                        System.out.println(str);
                    }
                } catch (IOException e) {
                    ClientSomthing.this.downService();
                }
            }
        }
        public class WriteMsg extends Thread {

            @Override
            public void run() {
                while (true) {
                    String userWord;
                    try {
                        time = new Date();
                        dt1 = new SimpleDateFormat("HH:mm:ss");
                        dtime = dt1.format(time);
                        userWord = inputUser.readLine();
                        if (userWord.equals("конец")) {
                            out.write("конец" + "\n");
                            ClientSomthing.this.downService();
                            break;
                        } else {
                            out.write("(" + dtime + ") " + login + ": " + userWord + "\n");
                        }
                        out.flush();
                    } catch (IOException e) {
                        ClientSomthing.this.downService();
                    }
                }
            }
        }
    }
    public static class Client {

        public static String ipAddress = "localhost";
        public static int port = 8080;
        public static void main(String[] args) {
            new ClientSomthing(ipAddress, port);
        }
    }
}
