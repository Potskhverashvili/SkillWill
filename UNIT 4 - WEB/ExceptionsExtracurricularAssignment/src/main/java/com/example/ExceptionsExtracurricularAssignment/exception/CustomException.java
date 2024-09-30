package com.example.ExceptionsExtracurricularAssignment.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;


    public CustomException(ErrorMessages errorMessages) {
        this.message = errorMessages.getMessage();
        this.httpStatus = errorMessages.getHttpStatus();
    }

    public CustomException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
