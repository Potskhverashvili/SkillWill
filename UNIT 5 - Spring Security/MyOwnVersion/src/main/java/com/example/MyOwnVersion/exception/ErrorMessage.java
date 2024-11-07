package com.example.MyOwnVersion.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessage {

    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXIST("Username already exists.", HttpStatus.CONFLICT),
    PASSWORD_INCORRECT("Password incorrect", HttpStatus.UNAUTHORIZED),
    USERNAME_OR_PASSWORD_INCORRECT("Username or password incorrect", HttpStatus.UNAUTHORIZED),
    USER_ACCOUNT_INACTIVE("Your account is currently inactive. Please contact support for assistance.", HttpStatus.FORBIDDEN),
    ADMIN_PROFILE_IMMUTABLE("Admin profile cannot be modified.", HttpStatus.FORBIDDEN),
    POST_NOT_FOUND("Post not found", HttpStatus.NOT_FOUND),
    COMMENT_NOT_FOUND("Comment not found", HttpStatus.NOT_FOUND),
    NOT_ALLOWED("You do not have permission", HttpStatus.FORBIDDEN);


    private final String message;
    private final HttpStatus httpStatus;

    ErrorMessage(String message, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}

