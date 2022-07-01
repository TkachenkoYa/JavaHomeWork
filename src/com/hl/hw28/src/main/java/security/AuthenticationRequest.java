package com.hl.hw28.src.main.java.security;

public record AuthenticationRequest(String username, String password, UserRole role) {
}
