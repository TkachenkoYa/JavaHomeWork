package com.hl.hw29.src.main.java.chat.application.security;

import com.hl.hw29.src.main.java.chat.application.storage.InMemoryUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.hl.hw29.src.main.java.chat.application.domain.User;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InMemoryUserDetailsService implements UserDetailsService {

    InMemoryUserRepository repository;

    @Override
    public UserDetails findByUsername(String username) throws AuthenticationException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new AuthenticationException("User not found."));
        return new UserDetails(user.getUsername(), user.getPassword());
    }

}
