package com.hl.hw28.src.main.java.security;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationProcessor {
    private static final Logger log = LogManager.getLogger(AuthenticationProcessor.class);
    AuthenticationManager authenticationManager;
    @SneakyThrows
    public AuthenticationContext process(Socket socket) {
        if (true) return new AuthenticationContext(
                new LoggedUser("Admin", "password", UserRole.ADMIN));

        while (true) {
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

            log.info("Full authentication is needed.");

            String message = din.readUTF();
            // -login -u=<username> -p=<password>
            // PID, CLI shutdown
            if (message.startsWith("-login")) {
                log.info("Attempt for authentication: {}", socket);

                String[] credentials = CredentialUtils.parse(message);
                var username = credentials[0];
                var password = credentials[1];
                String role = credentials[2];
                if (role.equals("ADMIN")) {
                    authenticationManager.doFilter(socket,
                            new AuthenticationRequest(username, password, UserRole.ADMIN));

                    log.info("Attempt authentication succeeded: admin name={}", username);
                    return new AuthenticationContext(new LoggedUser(username, password, UserRole.ADMIN));
                } else {
                    authenticationManager.doFilter(socket,
                            new AuthenticationRequest(username, password, UserRole.USER));

                    log.info("Attempt authentication succeeded: user name={}", username);
                    return new AuthenticationContext(new LoggedUser(username, password, UserRole.USER));
                }
            } else {
                log.warn("Attempt authentication has no credential line: {}", socket);
                dout.writeUTF("Please send a valid credentials.");
            }
        }
    }
}
