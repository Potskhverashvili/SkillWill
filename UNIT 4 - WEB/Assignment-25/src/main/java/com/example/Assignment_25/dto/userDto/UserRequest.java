package com.example.Assignment_25.dto.userDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRequest {

    @NotBlank(message = "name can not be null")
    String name;

    @NotBlank(message = "userName can not be null")
    String userName;

    @NotNull(message = "balance can not be null")
    Double balance;


    // --------------------- Constructors --------------------
    public UserRequest() {
    }

    public UserRequest(String name, String userName, Double balance) {
        this.name = name;
        this.userName = userName;
        this.balance = balance;
    }

    // -------------------- Setters and Getters -----------------------------

    public @NotNull(message = "balance can not be null") Double getBalance() {
        return balance;
    }

    public void setBalance(@NotNull(message = "balance can not be null") Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
