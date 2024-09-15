package com.example.GroupWork5.DTO.postDto;

public class ViewPost {
    private Long id;

    private String text;

    String ownerUser;

    // ------------------- Constructors ---------------------
    public ViewPost() {
    }

    public ViewPost(Long id, String text, String ownerUser) {
        this.id = id;
        this.text = text;
        this.ownerUser = ownerUser;
    }

    // ---------------- Setters and Getters ------------------
    public String getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(String ownerUser) {
        this.ownerUser = ownerUser;
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
