package com.example.Assignment24.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> handlerMyRunTimeException(MyRunTimeException ex) {
        Map<String, Object> exceptionDetails = new HashMap<>();
        exceptionDetails.put("Exception Name: ", ex.getClass().getSimpleName());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDetails);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getFieldErrors();
        ExceptionBody exceptionBody = new ExceptionBody(fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionBody);
    }
}
