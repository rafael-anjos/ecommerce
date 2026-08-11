package com.api.ecommerce.core.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.api.ecommerce.core.domain.entity.Product;

public interface ProductRepository {
    
    Product save ( Product product );

    Optional<Product> findById ( UUID id );

    void delete ( UUID id );

}
