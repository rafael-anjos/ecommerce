package com.api.ecommerce.infra.presentation.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.core.application.dto.request.UserRequest;
import com.api.ecommerce.core.application.dto.response.GetUserResponse;
import com.api.ecommerce.core.application.usecase.CreateUserUseCase;
import com.api.ecommerce.core.application.usecase.DeleteUserUseCase;
import com.api.ecommerce.core.application.usecase.GetUserByEmailUseCase;
import com.api.ecommerce.core.application.usecase.UpdateUserUseCase;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final CreateUserUseCase create;
    private final GetUserByEmailUseCase get;
    private final UpdateUserUseCase update;
    private final DeleteUserUseCase delete;

    public UserController ( 
        CreateUserUseCase create, 
        GetUserByEmailUseCase get,
        UpdateUserUseCase update,
        DeleteUserUseCase delete ) 
    {
        this.create = create;
        this.get = get;
        this.update = update;
        this.delete = delete;
    }

    @PostMapping
    public ResponseEntity<Void> create ( @RequestBody UserRequest request) {

        create.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }

    @GetMapping("/{email}")
    public ResponseEntity<GetUserResponse> get ( @PathVariable String email ) {
        
        return ResponseEntity.ok().body(get.execute(email));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update ( @PathVariable UUID id, @RequestBody UserRequest request ) {
        
        update.execute(id, request);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete ( @PathVariable String email ) {

        delete.execute(email);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
