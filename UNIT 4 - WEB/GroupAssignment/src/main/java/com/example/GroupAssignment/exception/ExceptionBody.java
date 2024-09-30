package com.example.GroupAssignment.exception;

import lombok.*;
import lombok.extern.java.Log;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class ExceptionBody {
    private String errorMessage;
    private HttpStatus httpStatus;
    private  String methodName;
    private String time;
}
