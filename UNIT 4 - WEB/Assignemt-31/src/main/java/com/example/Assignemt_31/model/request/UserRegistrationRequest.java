package com.example.Assignemt_31.model.request;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
