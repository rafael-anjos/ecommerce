package com.api.ecommerce.core.domain.entity;

import java.util.UUID;

import com.api.ecommerce.core.domain.exception.InvalidEmailException;
import com.api.ecommerce.core.domain.exception.InvalidNameException;

public class User {
    
    private UUID id;

    private String name;

    private String email;

    // New user
    public User ( String name, String email ) {
        this.id = UUID.randomUUID();
        changeName(name);
        changeEmail(email);
    }

    // User exists ( rebuilding )
    private User ( UUID id, String name, String email ) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId () { return id; }

    public String getName () { return name; }

    public String getEmail () { return email; }

    public void changeName ( String name ) {

        if (name == null || name.isBlank() || name.length() < 5) {
            throw new InvalidNameException(name);
        }

        this.name = name;

    }

    public void changeEmail ( String email ) {

        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new InvalidEmailException(email);
        }

        this.email = email;

    }

    public void update ( String name, String email ) {

        changeName(name);

        changeEmail(email);

    }
    
    public static User restore ( UUID id, String name, String email ) {

        return new User(id, name, email);
        
    }
}
