package com.api.ecommerce.infra.persistence.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.ecommerce.core.domain.security.PasswordHasher;

public class ArgonPasswordHasher implements PasswordHasher {
    
    private final PasswordEncoder passwordEncoder;

    public ArgonPasswordHasher ( PasswordEncoder passwordEncoder ) {
        this.passwordEncoder = passwordEncoder;
    }

    public String hash ( String password ) {

        return passwordEncoder.encode(password);

    }

    public boolean matches ( String rawPassword, String hashedPassword ) {

        return passwordEncoder.matches(rawPassword, hashedPassword);
        
    }
}
