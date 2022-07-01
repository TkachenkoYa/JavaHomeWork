package com.hl.hw28.src.main.java.security;

import com.hl.hw28.src.main.java.domain.User;
import com.hl.hw28.src.main.java.storage.InMemoryUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InMemoryUserDetailsService implements UserDetailsService{
    InMemoryUserRepository repository;

    @Override
    public UserDetails findByUsername(String username) throws AuthenticationException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new AuthenticationException("User not found."));
        return new UserDetails(user.getUsername(), user.getPassword());
    }
}
