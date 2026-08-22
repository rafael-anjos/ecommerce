package com.api.ecommerce.infra.persistence.repository.cart;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.api.ecommerce.infra.persistence.entity.CartItemEntity;

public interface SpringDataCartItemRepository extends JpaRepository<CartItemEntity, UUID> {
    
    @Modifying
    @Query("""
            DELETE FROM CartItemEntity item
            WHERE item.cart.id = :cartId
            AND item.productId = :productId
            """)
    void deleteByCartIdAndProductId (UUID cartId, UUID productId);
    
}
