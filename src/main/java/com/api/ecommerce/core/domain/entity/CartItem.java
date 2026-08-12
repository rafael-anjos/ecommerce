package com.api.ecommerce.core.domain.entity;

import com.api.ecommerce.core.domain.valueobject.cart_item.CartItemId;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.product.Quantity;

public class CartItem {
    
    private final CartItemId id;
    private final ProductId productId;
    private Quantity quantity;

    //New CartItem
    public CartItem ( ProductId productId, Quantity quantity ) {
        this.id = CartItemId.generate();
        this.productId = productId;
        this.quantity = quantity;
    }

    //Rebuilding
    private CartItem ( CartItemId id, ProductId productId, Quantity quantity ) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartItemId getId () { return id; }

    public ProductId getProductId () { return productId; }

    public Quantity getQuantity () { return quantity; }

    public void changeQuantity ( Quantity quantity ) {
        
        this.quantity = quantity;

    }

    public static CartItem restore ( CartItemId id, ProductId productId, Quantity quantity ) {

        return new CartItem(id, productId, quantity);

    }
}
