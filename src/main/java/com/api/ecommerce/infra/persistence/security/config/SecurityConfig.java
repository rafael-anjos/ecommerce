package com.api.ecommerce.infra.persistence.security.config;

import org.springframework.security.web.SecurityFilterChain;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

@Configuration
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;
    
    @Bean
    SecurityFilterChain securityFilterChain ( HttpSecurity http ) throws Exception {

        http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/api/auth/login",
                "/api/user"
            ).permitAll()
            .anyRequest()
            .authenticated()
        )
        .oauth2ResourceServer(oauth2 -> 
            oauth2.jwt(Customizer.withDefaults())
        );

        return http.build();

    }

    @Bean
    SecretKey jwtSecretKey () {

        return new SecretKeySpec(jwtSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

    }

    @Bean
    JwtEncoder jwtEncoder ( SecretKey secretKey ) {

        return NimbusJwtEncoder
                .withSecretKey(secretKey)
                .build();

    }

    @Bean
    JwtDecoder jwtDecoder ( SecretKey secretKey ) {

        return NimbusJwtDecoder
                .withSecretKey(secretKey)
                .build();

    }
    
}
