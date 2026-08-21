package com.api.ecommerce.core.domain.entity;

import java.math.BigDecimal;

import com.api.ecommerce.core.domain.valueobject.cart_item.CartItemId;
import com.api.ecommerce.core.domain.valueobject.product.Money;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.product.ProductName;
import com.api.ecommerce.core.domain.valueobject.product.Quantity;

public class CartItem {
    
    private final CartItemId id;
    private final ProductId productId;
    private ProductName productName;
    private Money valueCartItem;
    private Quantity quantity;

    //New CartItem
    public CartItem ( ProductId productId, ProductName productName, Quantity quantity, Money valueCartItem ) {
        this.id = CartItemId.generate();
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.valueCartItem = valueCartItem;
    }

    //Rebuilding
    private CartItem ( CartItemId id, ProductId productId, ProductName productName, Quantity quantity, Money valueCartItem ) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.valueCartItem = valueCartItem;
        this.quantity = quantity;
    }

    public CartItemId getId () { return id; }

    public ProductId getProductId () { return productId; }

    public ProductName getProductName () { return productName; }

    public Quantity getQuantity () { return quantity; }

    public Money getValueCartItem () { return valueCartItem; }

    public Money getSubTotal () {
        return Money.of(valueCartItem.value().multiply(BigDecimal.valueOf(quantity.value())));
    }

    public void increaseQuantity ( Quantity quantity ) {

        this.quantity = this.quantity.increase(quantity.value());

    }

    public static CartItem restore ( CartItemId id, ProductId productId, ProductName productName, Quantity quantity, Money valueCartItem ) {

        return new CartItem(id, productId, productName, quantity, valueCartItem);

    }
}
