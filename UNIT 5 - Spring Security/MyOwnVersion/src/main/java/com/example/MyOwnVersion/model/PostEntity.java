package com.example.MyOwnVersion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "text")
    private String text;

    // ------------- Relations ---------------
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    public PostEntity() {
    }
}