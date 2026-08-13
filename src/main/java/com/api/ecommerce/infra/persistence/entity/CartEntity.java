package com.api.ecommerce.infra.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.api.ecommerce.core.domain.valueobject.cart.CartStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartEntity {

    @Id
    private UUID id;

    private UUID userId;

    @OneToMany ( mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<CartItemEntity> items = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CartStatus status;
    
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
