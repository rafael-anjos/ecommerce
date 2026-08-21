package com.api.ecommerce.core.application.usecase.cart;

import com.api.ecommerce.core.application.dto.request.cart.AddItemInput;
import com.api.ecommerce.core.domain.entity.Cart;
import com.api.ecommerce.core.domain.entity.CartItem;
import com.api.ecommerce.core.domain.entity.Product;
import com.api.ecommerce.core.domain.exception.ProductNotFoundException;
import com.api.ecommerce.core.domain.exception.ResourceNotFoundException;
import com.api.ecommerce.core.domain.repository.CartRepository;
import com.api.ecommerce.core.domain.repository.ProductRepository;
import com.api.ecommerce.core.domain.valueobject.cart.CartId;
import com.api.ecommerce.core.domain.valueobject.product.Money;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.product.ProductName;
import com.api.ecommerce.core.domain.valueobject.product.Quantity;

public class AddItemToCartUseCase {
    
    private final CartRepository repository;
    private final ProductRepository productRepository;

    public AddItemToCartUseCase ( CartRepository repository, ProductRepository productRepository ) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    public void execute ( AddItemInput input ) {

        Cart cart = repository.findById(CartId.of(input.cartId()))
        .orElseThrow(() -> new ResourceNotFoundException());

        Product product = productRepository.findById(input.productId())
        .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        if (input.quantity() > product.getQuantity().value()) {
            throw new IllegalArgumentException("Quantity must be less or equal then product stock.");
        }

        CartItem item = new CartItem(
            ProductId.of(product.getId().value()), 
            ProductName.of(product.getName().value()),
            Quantity.of(input.quantity()),
            Money.of(product.getPrice().value())
        );

        cart.addItem(item);

        repository.save(cart);

    }

}
