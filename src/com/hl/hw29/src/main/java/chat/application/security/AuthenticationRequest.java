package com.hl.hw29.src.main.java.chat.application.security;

/**
 * Potentially existing user and may not be existing.
 */
public record AuthenticationRequest(String username, String password) {
}
