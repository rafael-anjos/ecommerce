package com.api.ecommerce.core.application.usecase.product;

import com.api.ecommerce.core.application.dto.request.product.CreateProductRequest;
import com.api.ecommerce.core.domain.entity.Product;
import com.api.ecommerce.core.domain.repository.ProductRepository;
import com.api.ecommerce.core.domain.valueobject.product.Money;
import com.api.ecommerce.core.domain.valueobject.product.ProductName;
import com.api.ecommerce.core.domain.valueobject.product.Quantity;
import com.api.ecommerce.core.domain.valueobject.product.Sku;

public class CreateProductUseCase {
    
    private final ProductRepository repository;

    public CreateProductUseCase ( ProductRepository repository ) {
        this.repository = repository;
    }

    public void execute ( CreateProductRequest request ) {

        ProductName name = ProductName.of(request.name());

        Money price = Money.of(request.price());

        Quantity quantity = Quantity.of(request.quantity());

        Sku sku = Sku.of(request.sku());

        Product product = new Product(

            name, 

            request.description(), 

            price, 

            quantity, 

            sku
        
        );

        repository.save(product);
        
    }
}
