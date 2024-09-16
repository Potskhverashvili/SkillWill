package com.example.GroupWork5.DTO.postDto;

public class ViewPost {
    private Long id;

    private String text;

    Long ownerUserId;

    // ------------------- Constructors ---------------------
    public ViewPost() {
    }

    public ViewPost(Long id, String text, Long ownerUserId) {
        this.id = id;
        this.text = text;
        this.ownerUserId = ownerUserId;
    }

    // ---------------- Setters and Getters ------------------
    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
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
