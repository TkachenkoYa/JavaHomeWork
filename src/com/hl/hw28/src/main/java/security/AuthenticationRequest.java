package com.hl.hw28.src.main.java.security;

import com.hl.hw28.src.main.java.domain.UserRole;

public record AuthenticationRequest(String username, String password, UserRole role) {
}
