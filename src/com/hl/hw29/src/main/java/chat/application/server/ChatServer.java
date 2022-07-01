package com.hl.hw29.src.main.java.chat.application.server;

import com.hl.hw29.src.main.java.chat.application.security.AuthenticationContext;
import com.hl.hw29.src.main.java.chat.application.security.AuthenticationProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer implements LogOutEvent{
    private static final Logger log = LogManager.getLogger(ChatServer.class);
    List<ClientHandler> clientHandlers = new ArrayList<>();
    AuthenticationProcessor authenticationProcessor = new AuthenticationProcessor(null);

    public ChatServer(int port) {
        log.info("Chat Server is starting up ...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("Chat Server started successfully.");
            while (true) {
                Socket potentialClient = serverSocket.accept();
                Executors.newCachedThreadPool().execute(() -> {
                            try {
                                AuthenticationContext ctx = authenticationProcessor.process(potentialClient);
                                clientHandlers.add(
                                        new BasicClientHandler(
                                                ctx.getUser().username(),
                                                potentialClient.getInputStream(),
                                                potentialClient.getOutputStream(),
                                                () -> clientHandlers.stream()
                                                        .map(ClientHandler::out)
                                                        .toList(),
                                                this)
                                );
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
        } catch (IOException e) {
            throw new RuntimeException("SWW during server start up.", e);
        }
    }
    @Override
    public void clientLogOut(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
        AuthenticationContext.remove(AuthenticationContext.getUser());
    }
}
