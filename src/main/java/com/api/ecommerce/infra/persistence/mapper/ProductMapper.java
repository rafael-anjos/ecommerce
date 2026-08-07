package com.api.ecommerce.infra.persistence.mapper;

import com.api.ecommerce.core.domain.entity.Product;
import com.api.ecommerce.core.domain.valueobject.product.Money;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.product.ProductName;
import com.api.ecommerce.core.domain.valueobject.product.Quantity;
import com.api.ecommerce.core.domain.valueobject.product.Sku;
import com.api.ecommerce.infra.persistence.entity.ProductEntity;

public class ProductMapper {
    
    public static ProductEntity toEntity ( Product product ) {

        return new ProductEntity(
            product.getId().value(), 
            product.getName().value(), 
            product.getDescription(), 
            product.getPrice().value(), 
            product.getQuantity().value(), 
            product.getSku().value()
        );

    }

    public static Product toDomain ( ProductEntity entity ) {

        return Product.restore(
            ProductId.of(entity.getId()),
            ProductName.of(entity.getName()), 
            entity.getDescription(), 
            Money.of(entity.getPrice()), 
            Quantity.of(entity.getQuantity()), 
            Sku.of(entity.getSku())
        );

    }
    
}
