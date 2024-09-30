package com.example.GroupAssignment.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomException.class)
    private ResponseEntity<ExceptionBody> handleCustomException(CustomException ex) {
        StackTraceElement stackTraceElement = ex.getStackTrace()[0];

        // ---- time format ---
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        String formattedTime = instant.toString();

        return ResponseEntity.status(ex.getHttpStatus())
                .body(new ExceptionBody(
                        ex.getMessage(),
                        ex.getHttpStatus(),
                        stackTraceElement.getMethodName(),
                        formattedTime)
                );
    }


    // ----------------------- Method Argument Not Valid ------------------------
   /* @ExceptionHandler
    private ResponseEntity<ExceptionBody> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        StackTraceElement stackTraceElement = ex.getStackTrace()[0];
        List<FieldError> fieldErrors = ex.getFieldErrors();

        String defaultMessage = fieldErrors.stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .toString();

        // ---- time format ---
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        String formattedTime = instant.toString();
        ExceptionBody exceptionBody = new ExceptionBody(defaultMessage, (HttpStatus) ex.getStatusCode(),stackTraceElement.getMethodName(), formattedTime );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionBody);
    }*/


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionBody> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        StackTraceElement stackTraceElement = ex.getStackTrace()[0];

        List<String> defaultMessages = fieldErrors.stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .toList();

        // ---- time format ---
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        String formattedTime = instant.toString();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
                ExceptionBody(
                defaultMessages.toString(),
                (HttpStatus) ex.getStatusCode(),
                stackTraceElement.getMethodName(),
                formattedTime));
    }
}
