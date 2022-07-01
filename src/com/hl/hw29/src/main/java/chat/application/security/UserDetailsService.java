package com.hl.hw29.src.main.java.chat.application.security;

public interface UserDetailsService {
    /**
     * @param username
     * @return existing user in the source
     * @throws AuthenticationException when no user found
     */
    UserDetails findByUsername(String username) throws AuthenticationException;
}
