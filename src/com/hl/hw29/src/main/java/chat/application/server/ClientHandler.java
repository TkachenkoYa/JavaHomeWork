package com.hl.hw29.src.main.java.chat.application.server;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientHandler {
    InputStream in();
    OutputStream out();
}
