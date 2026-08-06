package com.api.ecommerce.core.domain.valueobject.user;

import com.api.ecommerce.core.domain.exception.InvalidPasswordException;

public final class Password {
    
    private final String value;

    public Password ( String value ) {

        validate(value);

        this.value = value;

    }

    private void validate ( String value ) {

        if (value == null || value.isBlank()) {
            throw new InvalidPasswordException(
            "Password cannot be empty.");
        }

        if (value.length() < 8) {
            throw new InvalidPasswordException(
            "Password must contain at least 8 characters.");
        }

        if (!value.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException(
            "Password must contain an uppercase letter.");
        }

        if (!value.matches(".*[a-z].*")) {
            throw new InvalidPasswordException(
            "Password must contain an lowercase letter.");
        }

        if (!value.matches(".*\\d.*")) {
        throw new InvalidPasswordException(
            "Password must contain a number."
        );
        }

        if (!value.matches(".*[!@#$%^&*()].*")) {
        throw new InvalidPasswordException(
            "Password must contain a special character."
        );
        }

    }

    public static Password of ( String value ) {

        return new Password(value);

    }

    public String value () {

        return value;

    }
}
