package com.api.ecommerce.infra.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.core.application.dto.request.CreateUserRequest;
import com.api.ecommerce.core.application.usecase.CreateUserUseCase;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final CreateUserUseCase createUserUseCase;

    public UserController ( CreateUserUseCase createUserUseCase ) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> create ( @RequestBody CreateUserRequest request) {

        createUserUseCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }
}
