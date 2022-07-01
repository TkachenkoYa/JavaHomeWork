package com.hl.hw28.src.main.java.security;

public interface Authenticator {
    void attemptAuthenticate(AuthenticationRequest request);
}
