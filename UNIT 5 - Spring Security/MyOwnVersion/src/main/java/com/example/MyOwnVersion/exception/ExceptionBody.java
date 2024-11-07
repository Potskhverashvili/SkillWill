package com.example.MyOwnVersion.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionBody {
    private String errorMessage;
    private HttpStatus httpStatus;
    private String methodName;
    private String time;
}

