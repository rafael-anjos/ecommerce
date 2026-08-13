package com.api.ecommerce.infra.presentation.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.ecommerce.core.application.dto.response.exception.ErrorResponse;
import com.api.ecommerce.core.domain.exception.CartAlreadyExistsException;
import com.api.ecommerce.core.domain.exception.EmailAlreadyExistsException;
import com.api.ecommerce.core.domain.exception.EmailNotFoundException;
import com.api.ecommerce.core.domain.exception.InvalidCredentialsException;
import com.api.ecommerce.core.domain.exception.InvalidEmailException;
import com.api.ecommerce.core.domain.exception.InvalidIdException;
import com.api.ecommerce.core.domain.exception.InvalidNameException;
import com.api.ecommerce.core.domain.exception.InvalidPasswordException;
import com.api.ecommerce.core.domain.exception.ProductNotFoundException;
import com.api.ecommerce.core.domain.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalHandlerException {
    
    @ExceptionHandler ( EmailAlreadyExistsException.class )
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExists ( EmailAlreadyExistsException ex ) {

        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());

    }

    @ExceptionHandler ( CartAlreadyExistsException.class )
    public ResponseEntity<ErrorResponse> handleCartExists ( CartAlreadyExistsException ex ) {

        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());

    }

    @ExceptionHandler ( ProductNotFoundException.class )
    public ResponseEntity<ErrorResponse> handleProductNotFound ( ProductNotFoundException ex ) {

        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());

    }

    @ExceptionHandler ( InvalidPasswordException.class )
    public ResponseEntity<ErrorResponse> handleInvalidPassword ( InvalidPasswordException ex ) {

        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());

    }

    @ExceptionHandler ( EmailNotFoundException.class )
    public ResponseEntity<ErrorResponse> handleEmailNotFound ( EmailNotFoundException ex ) {

        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());

    }

    @ExceptionHandler ( ResourceNotFoundException.class )
    public ResponseEntity<ErrorResponse> handleUserNotFound ( ResourceNotFoundException ex ) {

        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());

    }

    @ExceptionHandler ( InvalidIdException.class )
    public ResponseEntity<ErrorResponse> handleInvalidId ( InvalidIdException ex ) {

        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());

    }

    @ExceptionHandler ( InvalidNameException.class )
    public ResponseEntity<ErrorResponse> handleInvalidName ( InvalidNameException ex ) {

        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());

    }

    @ExceptionHandler ( InvalidEmailException.class )
    public ResponseEntity<ErrorResponse> handleInvalidEmail ( InvalidEmailException ex ) {

        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());

    }

    @ExceptionHandler ( InvalidCredentialsException.class )
    public ResponseEntity<ErrorResponse> handleInvalidCredentials ( InvalidCredentialsException ex ) {

        return buildResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());

    }

    @ExceptionHandler ( IllegalArgumentException.class )
    public ResponseEntity<ErrorResponse> handleIllegalArgument ( IllegalArgumentException ex ) {

        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());

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
