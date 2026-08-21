package com.api.ecommerce.core.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.ecommerce.core.domain.valueobject.cart.CartId;
import com.api.ecommerce.core.domain.valueobject.cart.CartStatus;
import com.api.ecommerce.core.domain.valueobject.product.Money;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.user.UserId;

public class Cart {
    
    private final CartId id;
    private final UserId userId;
    private List<CartItem> items;
    private Money valueCart;
    private CartStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //New Cart
    public Cart ( UserId userId ) {
        this.id = CartId.generate();
        this.userId = userId;
        this.items = new ArrayList<>();
        this.valueCart = Money.zero();
        this.status = CartStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    //Rebuilding
    private Cart ( CartId id, UserId userId, List<CartItem> items, Money valueCart, CartStatus status, LocalDateTime createdAt, LocalDateTime updatedAt ) {
        this.id = id;
        this.userId = userId;
        this.items = new ArrayList<>(items);
        this.valueCart = valueCart;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CartId getId () { return id; };

    public UserId getUserId () { return userId; }

    public List<CartItem> getItems () { return items; }

    public Money getValue () { 

        return items.stream()
            .map(CartItem::getSubTotal)
            .reduce(Money.zero(), Money::add);

    }

    public CartStatus getStatus () { return status; }

    public LocalDateTime getCreatedAt () { return createdAt; }

    public LocalDateTime getUpdatedAt () { return updatedAt; }

    public void addItem ( CartItem item ) {

        Optional<CartItem> existingItem = items.stream()
        .filter(i -> i.getProductId().value().equals(item.getProductId().value()))
        .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().increaseQuantity(item.getQuantity());
        } else {
            items.add(item);
        }

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

    public boolean isActive () {

        return status == CartStatus.ACTIVE;

    }

    public static Cart restore ( CartId id, UserId userId, List<CartItem> items, Money valueCart, CartStatus status, LocalDateTime createdAt, LocalDateTime updatedAt ) {

        return new Cart(id, userId, items, valueCart, status, createdAt, updatedAt);

    }
}
