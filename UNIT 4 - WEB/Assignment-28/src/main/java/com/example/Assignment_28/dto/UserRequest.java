package com.example.Assignment_28.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "userName can not be null")
    @Size(min = 4, max = 16, message = "userName must be between 4-16")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "userName must be only letters or numbers")
    private String userName;

    @NotBlank(message = "password can not be null")
    @Size(min = 6, max = 12, message = "password mus be between 6-12")
    @Pattern(
            regexp = "^[a-zA-Z0-9!@#$%^&*?]+$",
            message = "Invalid input. " +
                    "Please enter only letters, numbers, " +
                    "and the following special characters: !@#$%^&*?")
    private String password;
}
