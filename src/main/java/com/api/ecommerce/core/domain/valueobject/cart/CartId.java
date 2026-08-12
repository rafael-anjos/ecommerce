package com.api.ecommerce.core.domain.valueobject.cart;

import java.util.UUID;

import com.api.ecommerce.core.domain.exception.InvalidIdException;

public class CartId {
    
    private final UUID value;

    public CartId ( UUID value ) {

        if (value == null) {
            throw new InvalidIdException("Cart id cannot be null.");
        }

        this.value = value;

    }

    public static CartId generate () {

        return new CartId(UUID.randomUUID());

    }

    public static CartId of ( UUID value ) {

        return new CartId(value);

    }

    public UUID value () {

        return value;

    }

    public String toString () {

        return value.toString();

    }
    
}
