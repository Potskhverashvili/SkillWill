package com.example.GroupWork5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "text")
    private String text;

    // ------------ Relation -----------
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    // ---------- Constructors ----------
    public PostEntity() {
    }

    public PostEntity(Long id, String text, UserEntity userEntity) {
        this.id = id;
        this.text = text;
        this.userEntity = userEntity;
    }

    // -------- Setters and Getters ------
    public String getUserName() {
        return userEntity.getUserName();
    }

    public Long getUserId(){
        return userEntity.getId();
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

}
