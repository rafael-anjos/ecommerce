package com.api.ecommerce.infra.presentation.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.ecommerce.core.application.dto.response.ErrorResponse;
import com.api.ecommerce.core.domain.exception.EmailAlreadyExistsException;

@RestControllerAdvice
public class GlobalHandlerException {
    
    @ExceptionHandler ( EmailAlreadyExistsException.class )
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExists ( EmailAlreadyExistsException ex ) {

        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());

    }

    private ResponseEntity<ErrorResponse> buildResponse ( HttpStatus status, String message) {

        ErrorResponse error = new ErrorResponse (

            status.value(),

            message,

            LocalDateTime.now()

        );

        return ResponseEntity.status(status).body(error);
        
    }
}
