package com.hl.hw29.src.main.java.chat.application;

import com.hl.hw29.src.main.java.chat.application.server.ChatServer;

public class Application {
    public static void main(String[] args) {
        new ChatServer(8080);
    }
}
