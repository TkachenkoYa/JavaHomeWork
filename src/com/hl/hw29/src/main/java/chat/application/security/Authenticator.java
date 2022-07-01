package com.hl.hw29.src.main.java.chat.application.security;

public interface Authenticator {
    void attemptAuthenticate(AuthenticationRequest request);
}
