package com.api.ecommerce.core.application.usecase.cart;

import com.api.ecommerce.core.application.dto.request.cart.RemoveItemInput;
import com.api.ecommerce.core.domain.exception.ResourceNotFoundException;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.valueobject.cart.CartId;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;

public class RemoveItemToCartUseCase {
    
    private final CartRepository repository;

    public RemoveItemToCartUseCase ( CartRepository repository ) {
        this.repository = repository;
    }

    public void execute ( RemoveItemInput input ) {

        repository.findById(CartId.of(input.cartId()))
        .orElseThrow(() -> new ResourceNotFoundException());

        repository.removeItem(
            CartId.of(input.cartId()), 
            ProductId.of(input.productId()));


    }


}
