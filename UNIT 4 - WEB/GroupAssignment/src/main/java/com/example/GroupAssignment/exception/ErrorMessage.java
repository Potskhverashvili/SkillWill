package com.example.GroupAssignment.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessage {

    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXIST("Username already exists.", HttpStatus.CONFLICT),
    POST_NOT_FOUND("Post not found", HttpStatus.NOT_FOUND),
    NOT_ALLOWED("You do not have permission", HttpStatus.FORBIDDEN),
    COMMENT_NOT_FOUND("Comment not found", HttpStatus.NOT_FOUND);


   private final String message;
   private final HttpStatus httpStatus;

    ErrorMessage(String message, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
