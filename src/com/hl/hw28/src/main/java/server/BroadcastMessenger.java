package com.hl.hw28.src.main.java.server;

import java.io.OutputStream;

public interface BroadcastMessenger {
    void doBroadcast(String message, Iterable<OutputStream> streams);
}
