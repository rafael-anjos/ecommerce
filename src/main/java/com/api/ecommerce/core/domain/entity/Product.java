package com.api.ecommerce.core.domain.entity;

import com.api.ecommerce.core.domain.valueobject.product.Money;
import com.api.ecommerce.core.domain.valueobject.product.ProductId;
import com.api.ecommerce.core.domain.valueobject.product.ProductName;
import com.api.ecommerce.core.domain.valueobject.product.Quantity;
import com.api.ecommerce.core.domain.valueobject.product.Sku;

public class Product {
    
    private final ProductId id;
    private ProductName name;
    private String description;
    private Money price;
    private Quantity quantity;
    private final Sku sku;

    // New product
    public Product ( ProductName name, String description, Money price, Quantity quantity, Sku sku ) {
        this.id = ProductId.generate();
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
    }

    // Rebuilding
    private Product ( ProductId id, ProductName name, String description, Money price, Quantity quantity, Sku sku ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
    }

    public ProductId getId () { return id; }

    public ProductName getName () { return name; }

    public String getDescription () { return description; }

    public Money getPrice () { return price; }

    public Quantity getQuantity () { return quantity; }

    public Sku getSku () { return sku; }

    public void changeName ( ProductName name ) {

        this.name = name;

    }

    public void changePrice ( Money price ) {

        this.price = price;

    }

    public void changeDescription ( String description ) {

        this.description = description;

    }

    public void addStock ( int quantity ) {

        this.quantity = this.quantity.increase(quantity);

    }

    public void removeStock ( int quantity ) {

        this.quantity = this.quantity.decrease(quantity);

    }

    public static Product restore ( ProductId id, ProductName name, String description, Money price, Quantity quantity, Sku sku ) {

        return new Product(id, name, description, price, quantity, sku);

    }
    
}
