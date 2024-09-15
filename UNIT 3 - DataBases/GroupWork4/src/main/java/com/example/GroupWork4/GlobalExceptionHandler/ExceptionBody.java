package com.example.GroupWork4.GlobalExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExceptionBody {

    private static final Logger log = LoggerFactory.getLogger(ExceptionBody.class);

    private final Map<String, Object> errorMessages = new HashMap<>();
    private List<FieldError> fieldErrors = new ArrayList<>();
    private RuntimeException generalError;

    // Constructor for validation errors
    public ExceptionBody(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    // Constructor for general exceptions
    public ExceptionBody(RuntimeException generalError) {
        this.generalError = generalError;
    }

    // Get Message Method for validation errors
    public Map<String, Object> getValidationErrorMessages() {
        for (FieldError fieldError : fieldErrors) {
            errorMessages.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errorMessages;
    }

    // Get Message Method for general exceptions
    public String getGeneralErrorMessage() {
        Throwable rootCause = generalError;
        while (rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }
        return rootCause.getMessage();
    }
}
