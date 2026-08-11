package com.api.ecommerce.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

import com.api.ecommerce.core.application.service.JwtTokenService;
import com.api.ecommerce.core.application.usecase.auth.LoginUseCase;
import com.api.ecommerce.core.application.usecase.user.CreateUserUseCase;
import com.api.ecommerce.core.application.usecase.user.DeleteUserUseCase;
import com.api.ecommerce.core.application.usecase.user.GetUserByEmailUseCase;
import com.api.ecommerce.core.application.usecase.user.UpdateUserUseCase;
import com.api.ecommerce.core.domain.repository.UserRepository;
import com.api.ecommerce.core.domain.security.PasswordHasher;
import com.api.ecommerce.infra.persistence.repository.user.JpaUserRepositoryAdapter;
import com.api.ecommerce.infra.persistence.repository.user.SpringDataUserRepository;
import com.api.ecommerce.infra.persistence.security.jwt.JwtTokenServiceImpl;
import com.api.ecommerce.infra.persistence.security.password.ArgonPasswordHasher;

@Configuration
public class UserBeanConfiguration {
    
    @Bean
    public CreateUserUseCase createUserUseCase ( UserRepository repository, PasswordHasher hasher ) {

        return new CreateUserUseCase(repository, hasher);

    }
    
    @Bean
    public GetUserByEmailUseCase getUserByEmailUseCase ( UserRepository repository ) {

        return new GetUserByEmailUseCase(repository);

    }

    @Bean
    public UpdateUserUseCase updateUserUseCase ( UserRepository repository ) {

        return new UpdateUserUseCase(repository);

    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase ( UserRepository repository ) {

        return new DeleteUserUseCase(repository);

    }

    @Bean
    public LoginUseCase loginUseCase ( UserRepository repository, PasswordHasher passwordHasher, JwtTokenService jwtTokenService ) {

        return new LoginUseCase(repository, passwordHasher, jwtTokenService);

    }

    @Bean
    public JwtTokenService jwtTokenService ( JwtEncoder jwtEncoder ) {

        return new JwtTokenServiceImpl(jwtEncoder);

    }

    @Bean
    public PasswordEncoder passwordEncoder () {

        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    }

    @Bean
    public PasswordHasher hasher ( PasswordEncoder passwordEncoder ) {

        return new ArgonPasswordHasher(passwordEncoder);

    }

    @Bean
    public UserRepository userRepository ( SpringDataUserRepository repository ) {

        return new JpaUserRepositoryAdapter(repository);

    }
}
