package com.hl.hw28.src.main.java.security;

public interface UserDetailsService {
    UserDetails findByUsername(String username) throws AuthenticationException;
}
