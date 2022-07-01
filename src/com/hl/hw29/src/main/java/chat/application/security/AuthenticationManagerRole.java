package com.hl.hw29.src.main.java.chat.application.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Socket;

public class AuthenticationManagerRole implements AuthenticationManager{
    Logger logger = LogManager.getLogger(AuthenticationManagerRole.class);
    @Override
    public void doFilter(Socket socket, AuthenticationRequest request) {

    }
}
