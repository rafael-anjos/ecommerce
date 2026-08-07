package com.api.ecommerce.infra.persistence.security.jwt;

import java.time.Instant;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import com.api.ecommerce.core.application.service.JwtTokenService;
import com.api.ecommerce.core.domain.entity.User;

public class JwtTokenServiceImpl implements JwtTokenService {
    
    private final JwtEncoder jwtEncoder;

    public JwtTokenServiceImpl ( JwtEncoder jwtEncoder ) {

        this.jwtEncoder = jwtEncoder;

    }

    public String generateToken ( User user ) {

        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
            .subject(user.getId().toString())
            .issuedAt(now)
            .expiresAt(now.plusSeconds(900))
            .claim("email", user.getEmail().value())
            .build();
        
        Jwt jwt = jwtEncoder.encode(JwtEncoderParameters.from(claims));
        
        return jwt.getTokenValue();
        
    }
}
