package com.example.ExceptionsExtracurricularAssignment.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

}
