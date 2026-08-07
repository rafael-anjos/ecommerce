package com.api.ecommerce.core.domain.valueobject.user;

import java.util.UUID;

import com.api.ecommerce.core.domain.exception.InvalidIdException;

public final class UserId {

    private final UUID value;

    public UserId ( UUID value ) {

        if (value == null) {
            throw new InvalidIdException("User id cannot be null.");
        }

        this.value = value;

    }

    public static UserId generate () {

        return new UserId(UUID.randomUUID());

    }

    public static UserId of ( UUID value ) {

        return new UserId(value);

    }

    public UUID value () {

        return value;

    }

    public String toString () {

        return value.toString();
        
    }
    
}
