package com.example.GroupWork5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    // ------------- Relations ---------------
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "post_id")
    PostEntity postEntity;

    // -------------- Constructors --------------
    public CommentEntity() {
    }

    public CommentEntity(String comment, Long id, PostEntity postEntity, UserEntity userEntity) {
        this.comment = comment;
        this.id = id;
        this.postEntity = postEntity;
        this.userEntity = userEntity;
    }

    // ------------- Setters and Getters -----------
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostEntity getPostEntity() {
        return postEntity;
    }

    public void setPostEntity(PostEntity postEntity) {
        this.postEntity = postEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
