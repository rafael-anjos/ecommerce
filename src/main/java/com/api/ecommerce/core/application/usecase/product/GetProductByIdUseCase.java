package com.api.ecommerce.core.application.usecase.product;

import java.util.UUID;

import com.api.ecommerce.core.application.dto.response.product.GetProductResponse;
import com.api.ecommerce.core.domain.entity.Product;
import com.api.ecommerce.core.domain.exception.ProductNotFoundException;
import com.api.ecommerce.core.domain.repository.ProductRepository;

public class GetProductByIdUseCase {
    
    private final ProductRepository repository;

    public GetProductByIdUseCase ( ProductRepository repository ) {
        this.repository = repository;
    }

    public GetProductResponse execute ( UUID id ) {

        Product product = repository.findById(id).orElseThrow(
            () -> new ProductNotFoundException("Product not found.")
        );

        return new GetProductResponse(

            product.getName().value(),

            product.getDescription(), 

            product.getPrice().value(), 

            product.getQuantity().value(),

            product.getSku().value()
            
        );

    }

}
