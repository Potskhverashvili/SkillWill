package com.example.ExceptionsExtracurricularAssignment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@Getter
public enum ErrorMessages {

    NOT_FOUND("Task Not Found", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;
}
