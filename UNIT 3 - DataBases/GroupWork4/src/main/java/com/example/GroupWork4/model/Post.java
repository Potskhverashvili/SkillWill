package com.example.GroupWork4.model;

import jakarta.persistence.*;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    // ---------- Relation --------
    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

    // -------- Constructors -----------
    public Post() {
    }

    public Post(Users user, Long id, String text) {
        this.user = user;
        this.id = id;
        this.text = text;
    }

    // ----------- Setters and Getters -----------------
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
