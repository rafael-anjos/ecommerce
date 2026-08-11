package com.api.ecommerce.core.application.usecase.product;

import java.util.UUID;

import com.api.ecommerce.core.application.dto.request.product.UpdateProductRequest;
import com.api.ecommerce.core.domain.entity.Product;
import com.api.ecommerce.core.domain.exception.ProductNotFoundException;
import com.api.ecommerce.core.domain.repository.ProductRepository;
import com.api.ecommerce.core.domain.valueobject.product.Money;
import com.api.ecommerce.core.domain.valueobject.product.ProductName;

public class UpdateProductUseCase {
    
    private final ProductRepository repository;

    public UpdateProductUseCase ( ProductRepository repository ) {
        this.repository = repository;
    }

    public void execute ( UUID id, UpdateProductRequest request ) {

        Product product = repository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        ProductName name = ProductName.of(request.name());
        Money price = Money.of(request.price());

        product.changeName(name);
        product.changeDescription(request.description());
        product.changePrice(price);

        repository.save(product);

    }
    
}
