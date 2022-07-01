package com.hl.hw28.src.main.java.server;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientHandler {
    InputStream in();
    OutputStream out();
}
