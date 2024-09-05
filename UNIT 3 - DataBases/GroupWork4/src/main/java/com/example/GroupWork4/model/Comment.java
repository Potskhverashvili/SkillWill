package com.example.GroupWork4.model;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.util.Objects;

@Entity
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String text;

    // ------------- Relations ----------------
    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;

    // ------------- Constructors --------------
    public Comment() {
    }

    public Comment(long id, String text) {
        this.id = id;
        this.text = text;
    }

    //---------- Setters and Getters ------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
