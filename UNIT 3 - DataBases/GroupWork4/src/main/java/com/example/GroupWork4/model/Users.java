package com.example.GroupWork4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Users {
    @Id
    @Column(name = "user_name", unique = true)
    @NotNull(message = "User name must not be null")
    @NotBlank(message = "User name must not be blank")
    @Size(min = 4, max = 10, message = "User name must be between 4 and 10 characters")
    private String userName;

    @Column(name = "first_name")
    @NotNull(message = "First name must not be null")
    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name must not be null")
    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthdate;

    public Users() {
    }

    public Users(String userName, String firstName, String lastName, LocalDate birthdate) {
        this.birthdate = birthdate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    // ------- Setters and Getters ---------
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
