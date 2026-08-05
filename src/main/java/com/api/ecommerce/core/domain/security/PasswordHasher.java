package com.api.ecommerce.core.domain.security;

public interface PasswordHasher {
    
    String hash ( String password );

    boolean matches ( String rawPassword, String hashedPassword );
    
}
