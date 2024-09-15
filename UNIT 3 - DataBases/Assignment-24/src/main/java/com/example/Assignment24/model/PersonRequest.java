package com.example.Assignment24.model;

import jakarta.validation.constraints.*;

public class PersonRequest {
    @NotNull(message = "user name can tot be null")
    @NotBlank(message = "user name can not be blank")
    String userName;

    @NotNull(message = "password can not be null")
    @NotBlank(message = "password can not be blank")
    @Size(min = 6, max = 15, message = "password should be between 6-15")
    String password;

    @NotNull(message = "firstName can not be null")
    @NotBlank(message = "firstName can not be blank")
    String firstName;

    @NotBlank(message = "lastName can not be blank")
    String lastName;

    @NotNull(message = "age can not be null")
    @Min(value = 18, message = "age should be greater or equal 18")
    @Max(value = 35, message = "age should be less or equal 35")
    Integer age;

    // -------------------------------- Constructors ------------------------------
    public PersonRequest() {
    }

    public PersonRequest(String password, String userName, Integer age) {
        this.password = password;
        this.userName = userName;
        this.age = age;
    }

    public PersonRequest(Integer age, String firstName, String lastName, String password, String userName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
    }

    // ------------------------------- Setters and Getters -----------------------

    public @NotNull(message = "user name can tot be null") @NotBlank(message = "user name can not be blank") String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull(message = "user name can tot be null") @NotBlank(message = "user name can not be blank") String userName) {
        this.userName = userName;
    }

    public @NotNull(message = "password can not be null") @NotBlank(message = "password can not be blank") @Size(min = 6, max = 15, message = "password should be between 6-15") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "password can not be null") @NotBlank(message = "password can not be blank") @Size(min = 6, max = 15, message = "password should be between 6-15") String password) {
        this.password = password;
    }

    public @NotBlank(message = "lastName can not be blank") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "lastName can not be blank") String lastName) {
        this.lastName = lastName;
    }

    public @NotNull(message = "firstName can not be null") @NotBlank(message = "firstName can not be blank") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "firstName can not be null") @NotBlank(message = "firstName can not be blank") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "age can not be null") @Min(value = 18, message = "age should be greater or equal 18") @Max(value = 35, message = "age should be less or equal 35") Integer getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "age can not be null") @Min(value = 18, message = "age should be greater or equal 18") @Max(value = 35, message = "age should be less or equal 35") Integer age) {
        this.age = age;
    }
}
