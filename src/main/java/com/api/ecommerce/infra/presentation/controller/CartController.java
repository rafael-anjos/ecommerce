package com.api.ecommerce.infra.presentation.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.core.application.dto.request.cart.AddItemInput;
import com.api.ecommerce.core.application.dto.request.cart.RemoveItemInput;
import com.api.ecommerce.core.application.dto.response.cart.GetCartResponse;
import com.api.ecommerce.core.application.usecase.cart.AddItemToCartUseCase;
import com.api.ecommerce.core.application.usecase.cart.ClearCartUseCase;
import com.api.ecommerce.core.application.usecase.cart.CreateCartUseCase;
import com.api.ecommerce.core.application.usecase.cart.GetCartUseCase;
import com.api.ecommerce.core.application.usecase.cart.RemoveItemToCartUseCase;
import com.api.ecommerce.core.domain.valueobject.cart.CartId;
import com.api.ecommerce.core.domain.valueobject.user.UserId;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CreateCartUseCase create;
    private final GetCartUseCase get;
    private final AddItemToCartUseCase addItem;
    private final RemoveItemToCartUseCase removeItem;
    private final ClearCartUseCase clearCart;

    public CartController ( 
        CreateCartUseCase create, 
        GetCartUseCase get,
        AddItemToCartUseCase addItem,
        RemoveItemToCartUseCase removeItem,
        ClearCartUseCase clearCart ) {
        this.create = create;
        this.get = get;
        this.addItem = addItem;
        this.removeItem = removeItem;
        this.clearCart = clearCart;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Void> create ( @PathVariable UUID userId ) {

        create.execute(UserId.of(userId));

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetCartResponse> get ( @PathVariable UUID userId ) {

        return ResponseEntity.ok().body(get.execute(UserId.of(userId)));

    }

    @PostMapping("/addItem")
    public ResponseEntity<Void> addItem ( @RequestBody AddItemInput input ) {

        addItem.execute(input);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/clearCart/{cartId}")
    public ResponseEntity<Void> clearCart ( @PathVariable UUID cartId ) {

        clearCart.execute(CartId.of(cartId));

        return ResponseEntity.ok().build();

    }

    @PostMapping("/removeItem")
    public ResponseEntity<Void> removeItem ( @RequestBody RemoveItemInput input ) {

        removeItem.execute(input);

        return ResponseEntity.ok().build();

    }
    
}
