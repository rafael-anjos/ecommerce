package com.api.ecommerce.core.application.usecase.product;

import java.util.UUID;

import com.api.ecommerce.core.domain.exception.ProductNotFoundException;
import com.api.ecommerce.core.domain.repository.ProductRepository;

public class DeleteProductUseCase {
    
    private final ProductRepository repository;

    public DeleteProductUseCase ( ProductRepository repository ) {
        this.repository = repository;
    }

    public void execute ( UUID id ) {

        if (repository.findById(id) == null) {
            throw new ProductNotFoundException("Product not found.");
        }

        repository.delete(id);

    }
}
