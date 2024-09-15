package com.example.Assignment24.exceptions;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExceptionBody {

    private final Map<String, Object> errorMessages = new HashMap<>();

    private final List<FieldError> fieldErrors;

    // Constructor
    public ExceptionBody(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    // Get Message Method
    public Map<String, Object> getErrorMessages() {
        for (FieldError fieldError : fieldErrors) {
            errorMessages.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errorMessages;
    }
}
