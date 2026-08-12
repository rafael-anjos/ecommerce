package com.api.ecommerce.core.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.api.ecommerce.core.domain.valueobject.cart.CartId;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.user.UserId;

public class Cart {
    
    private final CartId id;
    private final UserId userId;
    private List<CartItem> items;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //New Cart
    public Cart ( UserId userId ) {
        this.id = CartId.generate();
        this.userId = userId;
        this.items = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    //Rebuilding
    private Cart ( CartId id, UserId userId, List<CartItem> items, LocalDateTime createdAt, LocalDateTime updatedAt ) {
        this.id = id;
        this.userId = userId;
        this.items = new ArrayList<>(items);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CartId getId () { return id; };

    public UserId getUserId () { return userId; }

    public List<CartItem> getItems () { return Collections.unmodifiableList(items); }

    public LocalDateTime getCreatedAt () { return createdAt; }

    public LocalDateTime getUpdatedAt () { return updatedAt; }

    public void addItem ( CartItem item ) {

        items.add(item);

        this.updatedAt = LocalDateTime.now();

    }

    public void removeItem ( ProductId productId ) {

        items.removeIf(
            item -> item.getProductId().equals(productId)
        );

        this.updatedAt = LocalDateTime.now();

    }

    public void clear () {

        items.clear();

        this.updatedAt = LocalDateTime.now();

    }

    public static Cart restore ( CartId id, UserId userId, List<CartItem> items, LocalDateTime createdAt, LocalDateTime updatedAt ) {

        return new Cart(id, userId, items, createdAt, updatedAt);

    }
}
