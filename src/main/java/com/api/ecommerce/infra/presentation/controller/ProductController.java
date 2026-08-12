package com.api.ecommerce.infra.presentation.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.core.application.dto.request.product.CreateProductRequest;
import com.api.ecommerce.core.application.dto.request.product.UpdateProductRequest;
import com.api.ecommerce.core.application.dto.response.product.GetProductResponse;
import com.api.ecommerce.core.application.usecase.product.AddStockUseCase;
import com.api.ecommerce.core.application.usecase.product.CreateProductUseCase;
import com.api.ecommerce.core.application.usecase.product.DeleteProductUseCase;
import com.api.ecommerce.core.application.usecase.product.GetProductByIdUseCase;
import com.api.ecommerce.core.application.usecase.product.RemoveStockUseCase;
import com.api.ecommerce.core.application.usecase.product.UpdateProductUseCase;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    private final CreateProductUseCase create;
    private final GetProductByIdUseCase get;
    private final UpdateProductUseCase update;
    private final DeleteProductUseCase delete;
    private final AddStockUseCase addStock;
    private final RemoveStockUseCase removeStock;

    public ProductController ( 
        CreateProductUseCase create,
        GetProductByIdUseCase get,
        UpdateProductUseCase update,
        DeleteProductUseCase delete,
        AddStockUseCase addStock,
        RemoveStockUseCase removeStock ) {
        this.create = create;
        this.get = get;
        this.update = update;
        this.delete = delete;
        this.addStock = addStock;
        this.removeStock = removeStock;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct ( @RequestBody CreateProductRequest request ) {

        create.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> getProduct ( @PathVariable UUID id ) {

        return ResponseEntity.ok().body(get.execute(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct ( @PathVariable UUID id, @RequestBody UpdateProductRequest request ) {

        update.execute(id, request);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct ( @PathVariable UUID id ) {

        delete.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PatchMapping("/{id}/add")
    public ResponseEntity<Void> addStockProduct ( @PathVariable UUID id, @RequestBody int value ) {

        addStock.execute(id, value);

        return ResponseEntity.ok().build();

    }

    @PatchMapping("/{id}/remove")
    public ResponseEntity<Void> removeStockProduct ( @PathVariable UUID id, @RequestBody int value ) {

        removeStock.execute(id, value);

        return ResponseEntity.ok().build();

    }

}
