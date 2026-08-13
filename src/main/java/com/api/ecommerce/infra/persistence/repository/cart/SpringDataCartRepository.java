package com.api.ecommerce.infra.persistence.repository.cart;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.core.domain.valueobject.cart.CartStatus;
import com.api.ecommerce.infra.persistence.entity.CartEntity;

public interface SpringDataCartRepository extends JpaRepository<CartEntity, UUID>{
    
    Optional<CartEntity> findById ( UUID id );

    Optional<CartEntity> findByUserIdAndStatus ( UUID id, CartStatus status );

    boolean existsByUserId ( UUID id );
    
}
