package com.api.ecommerce.core.application.usecase.cart;

import com.api.ecommerce.core.application.dto.response.cart.GetCartResponse;
import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.exception.ResourceNotFoundException;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.valueobject.user.UserId;

public class GetCartUseCase {
    
    private final CartRepository repository;

    public GetCartUseCase ( CartRepository repository ) {
        this.repository = repository;
    }

    public GetCartResponse execute ( UserId userId ) {

        Cart cart = repository.findActiveByUserId(userId)
        .orElseThrow(() -> new ResourceNotFoundException());

        return new GetCartResponse(

            cart.getId().value(), 

            cart.getUserId().value(), 

            cart.getItems().size(),
            
            cart.getValue().value(),

            cart.getItems(), 

            cart.getStatus()
            
        );

    }

}
