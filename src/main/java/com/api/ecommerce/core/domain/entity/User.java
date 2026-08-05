package com.api.ecommerce.core.domain.entity;

import java.util.UUID;

import com.api.ecommerce.core.domain.exception.InvalidEmailException;
import com.api.ecommerce.core.domain.exception.InvalidNameException;
import com.api.ecommerce.core.domain.exception.InvalidPasswordException;

public class User {
    
    private UUID id;

    private String name;

    private String email;

    private String password;

    // New user
    public User ( String name, String email, String password ) {
        this.id = UUID.randomUUID();
        changeName(name);
        changeEmail(email);
        validatePassword(password);
    }

    // User exists ( rebuilding )
    private User ( UUID id, String name, String email, String password ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getId () { return id; }

    public String getName () { return name; }

    public String getEmail () { return email; }

    public String getPassword () { return password; }

    public void changeName ( String name ) {

        if (name == null || name.isBlank()) {
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

    public void validatePassword ( String password ) {

        if (password == null || password.isBlank()) {
            throw new InvalidPasswordException(
            "Password cannot be empty.");
        }

        if (password.length() < 8) {
            throw new InvalidPasswordException(
            "Password must contain at least 8 characters.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException(
            "Password must contain an uppercase letter.");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException(
            "Password must contain an lowercase letter.");
        }

        if (!password.matches(".*\\d.*")) {
        throw new InvalidPasswordException(
            "Password must contain a number."
        );
        }

        if (!password.matches(".*[!@#$%^&*()].*")) {
        throw new InvalidPasswordException(
            "Password must contain a special character."
        );
        }

        this.password = password;

    }

    public void update ( String name, String email ) {

        changeName(name);

        changeEmail(email);

    }
    
    public static User restore ( UUID id, String name, String email, String password ) {

        return new User(id, name, email, password);
        
    }
}
