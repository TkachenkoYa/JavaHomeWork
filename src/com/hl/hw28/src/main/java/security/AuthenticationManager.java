package com.hl.hw28.src.main.java.security;

import java.net.Socket;

public interface AuthenticationManager {
    void doFilter(Socket socket, AuthenticationRequest request);
}
