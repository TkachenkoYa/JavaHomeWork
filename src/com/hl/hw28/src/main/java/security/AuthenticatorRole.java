package com.hl.hw28.src.main.java.security;

import java.util.Objects;

public class AuthenticatorRole extends AbstractAuthenticator {
    public AuthenticatorRole(UserDetailsService userDetailsService) {
        super(userDetailsService);
    }

    @Override
    public void attemptAuthenticate(AuthenticationRequest request) {
        UserDetails userDetails = getUserDetailsService().findByUsername(request.username());
        if (!Objects.equals(userDetails.role(), request.role())) {
            throw new AuthenticationException("Role not found");
        }
    }
}

