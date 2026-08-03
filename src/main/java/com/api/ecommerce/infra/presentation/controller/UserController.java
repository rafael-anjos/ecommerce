package com.api.ecommerce.infra.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.core.application.dto.request.CreateUserRequest;
import com.api.ecommerce.core.application.dto.response.GetUserResponse;
import com.api.ecommerce.core.application.usecase.CreateUserUseCase;
import com.api.ecommerce.core.application.usecase.GetUserByEmailUseCase;
import com.api.ecommerce.core.domain.entity.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final CreateUserUseCase createUserUseCase;
    private final GetUserByEmailUseCase getUserByEmailUseCase;

    public UserController ( 
        CreateUserUseCase createUserUseCase, 
        GetUserByEmailUseCase getUserByEmailUseCase ) 
    {
        this.createUserUseCase = createUserUseCase;
        this.getUserByEmailUseCase = getUserByEmailUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> create ( @RequestBody CreateUserRequest request) {

        createUserUseCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }

    @GetMapping("/{email}")
    public ResponseEntity<GetUserResponse> get ( @PathVariable String email ) {
        
        return ResponseEntity.ok().body(getUserByEmailUseCase.execute(email));

    }
}
