package com.hl.hw29.src.main.java.chat.application.security;

import java.net.Socket;

public interface AuthenticationManager {
    void doFilter(Socket socket, AuthenticationRequest request);
}
