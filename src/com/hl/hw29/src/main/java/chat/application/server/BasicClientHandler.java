package com.hl.hw29.src.main.java.chat.application.server;

import com.hl.hw29.src.main.java.chat.application.server.BroadcastMessenger;
import com.hl.hw29.src.main.java.chat.application.server.ClientHandler;
import com.hl.hw29.src.main.java.chat.application.server.UTFBroadcastMessenger;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BasicClientHandler implements ClientHandler {

    String name;
    DataInputStream in;
    DataOutputStream out;
    BroadcastMessenger messenger = new UTFBroadcastMessenger();
    private final LogOutEvent event;

    public BasicClientHandler(String name, InputStream in, OutputStream out,
                              Supplier<Iterable<OutputStream>> outStreams, LogOutEvent event) {
        this.name = name;
        this.in = new DataInputStream(in);
        this.out = new DataOutputStream(out);
        Executors.newSingleThreadExecutor().execute(() -> listen(outStreams));
        this.event = event;
    }

    @SneakyThrows
    private void listen(Supplier<Iterable<OutputStream>> outStreams) {
        messenger.doBroadcast(name + " connected.", outStreams.get());
        while (true) {
            String message = this.in.readUTF();
            if (message.contains("-logout")) {
                logout();
                return;
            } else {
                messenger.doBroadcast(name + ": " + message, outStreams.get());
            }
        }
    }

    @Override
    public InputStream in() {
        return in;
    }

    @Override
    public OutputStream out() {
        return out;
    }

    @SneakyThrows
    private void logout() {
        in.close();
        out.close();
        event.clientLogOut(this);
    }
}

