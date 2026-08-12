package com.api.ecommerce.core.domain.valueobject.cart_item;

import java.util.UUID;

import com.api.ecommerce.core.domain.exception.InvalidIdException;

public class CartItemId {
    
    private final UUID value;

    public CartItemId ( UUID value ) {

        if (value == null) {
            throw new InvalidIdException("Cart item id cannot be null.");
        }

        this.value = value;
    }

    public static CartItemId generate () {

        return new CartItemId(UUID.randomUUID());

    }

    public static CartItemId of ( UUID value ) {

        return new CartItemId(value);

    }

    public UUID value () {

        return value;

    }

    public String toString () {

        return value.toString();

    }
    
}
