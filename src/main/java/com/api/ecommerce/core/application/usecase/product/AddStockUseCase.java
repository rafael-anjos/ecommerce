package com.api.ecommerce.core.application.usecase.product;

import java.util.UUID;

import com.api.ecommerce.core.domain.entity.Product;
import com.api.ecommerce.core.domain.exception.ProductNotFoundException;
import com.api.ecommerce.core.domain.repository.ProductRepository;

public class AddStockUseCase {
    
    private final ProductRepository repository;

    public AddStockUseCase ( ProductRepository repository ) {
        this.repository = repository;
    }

    public void execute ( UUID id, int value ) {

        Product product = repository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        product.addStock(value);

        repository.save(product);

    }
    
}
