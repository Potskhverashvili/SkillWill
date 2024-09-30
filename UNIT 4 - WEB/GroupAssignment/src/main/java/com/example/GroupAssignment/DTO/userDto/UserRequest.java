package com.example.GroupAssignment.DTO.userDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
@Data
public class UserRequest {

    @NotNull(message = "userName can not be null")
    @Size(min = 4, max = 16, message = "userName must be between 4-16")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "userName must be only letters or numbers")
    private String userName;

    @NotNull(message = "name can not be null")
    @Size(min = 2, max = 32, message = "name must be between 2-32")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "name must be only letters")
    private String name;

    @NotNull(message = "surname can not be null")
    @Size(min = 2, max = 64, message = "surname must be between 2-64")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "surname must be only letters")
    private String surname;

    @NotNull(message = "birthdate can not be null")
    @Past(message = "birthdate can not be in future")
    private LocalDate birthdate;
}
