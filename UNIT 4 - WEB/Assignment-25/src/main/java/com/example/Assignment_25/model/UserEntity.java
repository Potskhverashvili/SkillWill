package com.example.Assignment_25.model;

import jakarta.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "balance")
    Double balance;

    // --------------------- Constructors --------------------------
    public UserEntity() {
    }

    public UserEntity(Long id, String name, String userName, Double balance) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.balance = balance;
    }

    // ------------------- Setters and getters ---------------------
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
