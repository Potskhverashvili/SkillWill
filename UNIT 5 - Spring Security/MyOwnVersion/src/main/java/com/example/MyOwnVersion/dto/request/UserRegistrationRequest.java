package com.example.MyOwnVersion.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {

    @NotBlank(message = "userName can not be blank")
    @Size(min = 4, max = 16, message = "userName must be between 4-16")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "userName must be only letters or numbers")
    private  String username;

    @Size(min = 6, message = "is too short (minimum is 6 characters)")
    private  String password;

    @NotBlank(message = "firstName can not be null")
    @Size(min = 2, max = 32, message = "name must be between 2-32")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "name must be only letters")
    private  String firstName;

    @NotBlank(message = "lastName can not be null")
    @Size(min = 2, max = 64, message = "surname must be between 2-64")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "surname must be only letters")
    private  String LastName;

    @NotNull(message = "Date of birth cannot be null")
    @PastOrPresent(message = "Date of birth cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

}
