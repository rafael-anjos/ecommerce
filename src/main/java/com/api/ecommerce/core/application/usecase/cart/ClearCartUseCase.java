package com.api.ecommerce.core.application.usecase.cart;

import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.exception.ResourceNotFoundException;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.valueobject.cart.CartId;

public class ClearCartUseCase {
    
    private final CartRepository repository;

    public ClearCartUseCase ( CartRepository repository ) {
        this.repository = repository;
    }

    public void execute ( CartId id ) {

        Cart cart = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException()
        );

        cart.clear();

        repository.save(cart);
        
    }
}
