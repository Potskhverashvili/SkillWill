package com.example.Assignment._1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    private Long userId;

    private String userName;
    private String firstName;
}
