package com.hl.hw28.src.main.java.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationManagerRole implements AuthenticationManager{
    Logger logger = LogManager.getLogger(AuthenticationManagerRole.class);
    UserDetailsService userDetailsService;
    List<Authenticator> authenticators = List.of(
            new CredentialsAuthenticator(userDetailsService),
            new AuthenticatorRole(userDetailsService));

    @Override
    public void doFilter(Socket socket, AuthenticationRequest request) {
        try {
            authenticators.stream().forEach(a -> a.attemptAuthenticate(request));
        } catch (AuthenticationException e) {
            logger.debug(request.username() + " is not authenticate");
        }
    }
}
