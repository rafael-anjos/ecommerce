package com.api.ecommerce.infra.persistence.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
@NoArgsConstructor
@Getter
@Setter
public class CartItemEntity {

    @Id
    private UUID id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private CartEntity cart;

    private UUID productId;

    private String productName;

    private BigDecimal valueCartItem;

    private int quantity;

    public CartItemEntity ( UUID id, UUID productId, String productName, BigDecimal valueCartItem, int quantity ) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.valueCartItem = valueCartItem;
        this.quantity = quantity;
    }
    
}
