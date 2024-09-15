package com.example.GroupWork5.DTO.userDto;


import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserResponse {

    @NotNull(message = "Id can not be null")
    private Long id;

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

    // ----------------- Constructors ----------------
    public UserResponse() {
    }

    public UserResponse(LocalDate birthdate, Long id, String name, String surname, String userName) {
        this.birthdate = birthdate;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
    }

    // ---------------- Setters and Getters --------------
    public @NotNull(message = "birthdate can not be null") @Past(message = "birthdate can not be in future") LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(@NotNull(message = "birthdate can not be null") @Past(message = "birthdate can not be in future") LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public @NotNull(message = "Id can not be null") Long getId() {
        return id;
    }

    public void setId(@NotNull(message = "Id can not be null") Long id) {
        this.id = id;
    }

    public @NotNull(message = "name can not be null") @Size(min = 2, max = 32, message = "name must be between 2-32") @Pattern(regexp = "^[a-zA-Z]+$", message = "name must be only letters") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "name can not be null") @Size(min = 2, max = 32, message = "name must be between 2-32") @Pattern(regexp = "^[a-zA-Z]+$", message = "name must be only letters") String name) {
        this.name = name;
    }

    public @NotNull(message = "surname can not be null") @Size(min = 2, max = 64, message = "surname must be between 2-64") @Pattern(regexp = "^[a-zA-Z]+$", message = "surname must be only letters") String getSurname() {
        return surname;
    }

    public void setSurname(@NotNull(message = "surname can not be null") @Size(min = 2, max = 64, message = "surname must be between 2-64") @Pattern(regexp = "^[a-zA-Z]+$", message = "surname must be only letters") String surname) {
        this.surname = surname;
    }

    public @NotNull(message = "userName can not be null") @Size(min = 4, max = 16, message = "userName must be between 4-16") @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "userName must be only letters or numbers") String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull(message = "userName can not be null") @Size(min = 4, max = 16, message = "userName must be between 4-16") @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "userName must be only letters or numbers") String userName) {
        this.userName = userName;
    }
}
