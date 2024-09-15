package com.example.GroupWork4.GlobalExceptionHandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getFieldErrors();
        ExceptionBody exceptionBody = new ExceptionBody(fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionBody.getValidationErrorMessages());
    }


    @ExceptionHandler
    protected ResponseEntity<Object> handelRunTimeException(RuntimeException ex) {
        ExceptionBody exceptionBody = new ExceptionBody(ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionBody.getGeneralErrorMessage());
    }
}
