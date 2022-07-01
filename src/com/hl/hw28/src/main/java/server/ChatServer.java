package com.hl.hw28.src.main.java.server;

import com.hl.hw28.src.main.java.security.AuthenticationContext;
import com.hl.hw28.src.main.java.security.AuthenticationProcessor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {
    private static final Logger log = LogManager.getLogger(ChatServer.class);

    List<ClientHandler> clientHandlers = new ArrayList<>();
    AuthenticationProcessor authenticationProcessor = new AuthenticationProcessor(null);

    public ChatServer(int port) {
        log.info("Chat Server is starting up ...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("Chat Server started successfully.");

            while (true) {
                Socket potentialClient = serverSocket.accept();

                new Thread(() -> {
                    try {
                        AuthenticationContext ctx = authenticationProcessor.process(potentialClient);
                        clientHandlers.add(
                                new BasicClientHandler(
                                        ctx.user().username(),
                                        potentialClient.getInputStream(),
                                        potentialClient.getOutputStream(),
                                        () -> clientHandlers.stream()
                                                .map(ClientHandler::out)
                                                .toList()
                                )
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                        .start();
            }

        } catch (IOException e) {
            throw new RuntimeException("SWW during server start up.", e);
        }
    }
}
