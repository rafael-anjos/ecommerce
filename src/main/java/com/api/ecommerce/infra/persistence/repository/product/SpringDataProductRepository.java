package com.api.ecommerce.infra.persistence.repository.product;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.infra.persistence.entity.ProductEntity;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, UUID> {

    Optional<ProductEntity> findById ( UUID id );
    
}
