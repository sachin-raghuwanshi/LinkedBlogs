package com.programmers.blogwebsite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerExceptionClass {
    @ExceptionHandler(ResourceNotfoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundExceptionClass(ResourceNotfoundException resourceNotfoundException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(resourceNotfoundException.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> requestBodyValidationExceptionClass(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> resp = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
}
