package com.api.ecommerce.infra.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.core.application.dto.request.auth.LoginRequest;
import com.api.ecommerce.core.application.dto.response.auth.LoginResponse;
import com.api.ecommerce.core.application.usecase.auth.LoginUseCase;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final LoginUseCase loginUseCase;

    public AuthController ( LoginUseCase loginUseCase ) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login ( @RequestBody LoginRequest request ) {

        String token = loginUseCase.execute(request);

        return ResponseEntity.ok(new LoginResponse(token));

    }
}
