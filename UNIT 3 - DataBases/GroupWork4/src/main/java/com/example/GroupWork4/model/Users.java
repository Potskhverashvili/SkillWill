package com.example.GroupWork4.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Users {
    @Id
    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
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
