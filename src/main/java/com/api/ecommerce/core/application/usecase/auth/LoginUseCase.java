package com.api.ecommerce.core.application.usecase.auth;

import com.api.ecommerce.core.application.dto.request.auth.LoginRequest;
import com.api.ecommerce.core.application.service.JwtTokenService;
import com.api.ecommerce.core.domain.entity.User;
import com.api.ecommerce.core.domain.exception.InvalidCredentialsException;
import com.api.ecommerce.core.domain.exception.ResourceNotFoundException;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.core.domain.security.PasswordHasher;

public class LoginUseCase {
    
    private final UserRepository repository;
    private final PasswordHasher passwordHasher;
    private final JwtTokenService jwtTokenService;

    public LoginUseCase ( 
        UserRepository repository,
        PasswordHasher passwordHasher,
        JwtTokenService jwtTokenService) {

            this.repository = repository;
            this.passwordHasher = passwordHasher;
            this.jwtTokenService = jwtTokenService;
        }
    
    public String execute ( LoginRequest request ) {

        User user = repository.findByEmail(request.email());

        if (user == null) {
            throw new ResourceNotFoundException();
        }

        boolean passwordCorrect = passwordHasher.matches(

            request.password(), 
            
            user.getPassword().value());
        
        if (!passwordCorrect) {
            throw new InvalidCredentialsException("Credentials invalid.");
        }
        
        return jwtTokenService.generateToken(user);

    }
}
