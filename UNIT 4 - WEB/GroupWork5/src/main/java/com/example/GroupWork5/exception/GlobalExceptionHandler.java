package com.example.GroupWork5.exception;

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

@ControllerAdvice
public class GlobalExceptionHandler {

    // ----------------------- Method Argument Not Valid ------------------------
    @ExceptionHandler
    private ResponseEntity<ExceptionBody> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ExceptionBody exceptionBody = new ExceptionBody();
        List<FieldError> fieldErrors = exception.getFieldErrors();
        List<String> messages = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            messages.add(fieldError.getDefaultMessage());
        }

        // ---- time format ---
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        String formattedTime = instant.toString();

        exceptionBody.setTime(formattedTime);
        exceptionBody.setMessage(messages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionBody);
    }

    // ----------------------------- Response Status ------------------------
    @ExceptionHandler
    private ResponseEntity<ExceptionBody> handleResponseStatusException(ResponseStatusException exception) {
        ExceptionBody exceptionBody = new ExceptionBody();

        // ---- time format ---
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        String formattedTime = instant.toString();
        exceptionBody.setTime(formattedTime);

        exceptionBody.setMessage(List.of(exception.getMessage()));

        return ResponseEntity.status(exception.getStatusCode()).body(exceptionBody);
    }

    // ---------------------------------- Runtime -----------------------------
    @ExceptionHandler
    private ResponseEntity<ExceptionBody> handleRuntimeException(RuntimeException exception) {
        ExceptionBody exceptionBody = new ExceptionBody();

        // ---- time format ---
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        String formattedTime = instant.toString();
        exceptionBody.setTime(formattedTime);
        exceptionBody.setMessage(List.of(exception.getMessage()));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionBody);
    }
}
