package ua.ithillel.chat.application;

import ua.ithillel.chat.application.server.ChatServer;

public class Application {
    public static void main(String[] args) {
        new ChatServer(8080);
    }
}
