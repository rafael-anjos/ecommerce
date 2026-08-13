package com.api.ecommerce.core.domain.repository;

import java.util.Optional;

import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.valueobject.cart.CartId;
import com.api.ecommerce.core.domain.valueobject.user.UserId;

public interface CartRepository {
    
    Cart save ( Cart cart );

    Optional<Cart> findById ( CartId id );

    Optional<Cart> findActiveByUserId ( UserId userId );

    boolean existsByUserId ( UserId userId );
    
}
