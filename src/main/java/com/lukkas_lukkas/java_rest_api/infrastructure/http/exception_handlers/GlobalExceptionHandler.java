package com.lukkas_lukkas.java_rest_api.infrastructure.http.exception_handlers;

import com.lukkas_lukkas.java_rest_api.domain.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException exception) {
        return new ResponseEntity<>(
                exception.getMessages(),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }
}
