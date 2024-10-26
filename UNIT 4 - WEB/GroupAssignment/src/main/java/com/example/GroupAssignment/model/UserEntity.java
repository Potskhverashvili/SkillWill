package com.example.GroupAssignment.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    public UserEntity() {
    }

    public UserEntity(String userName, String name, String surname, LocalDate birthdate) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }
}
