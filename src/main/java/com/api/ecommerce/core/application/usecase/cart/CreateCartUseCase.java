package com.api.ecommerce.core.application.usecase.cart;

import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.exception.CartAlreadyExistsException;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.valueobject.user.UserId;

public class CreateCartUseCase {
    
    private final CartRepository repository;

    public CreateCartUseCase ( CartRepository repository ) {
        this.repository = repository;
    }

    public void execute ( UserId userId ) {

        if (repository.existsByUserId(userId)) {
            throw new CartAlreadyExistsException("Cart for this user already exists.");
        }

        Cart cart = new Cart(userId);

        repository.save(cart);

    }
    
}
