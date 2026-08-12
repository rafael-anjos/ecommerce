package com.api.ecommerce.infra.presentation.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.core.application.usecase.cart.CreateCartUseCase;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CreateCartUseCase create;

    public CartController ( CreateCartUseCase create ) {
        this.create = create;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> create ( @PathVariable UUID id ) {

        create.execute(id);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    
}
