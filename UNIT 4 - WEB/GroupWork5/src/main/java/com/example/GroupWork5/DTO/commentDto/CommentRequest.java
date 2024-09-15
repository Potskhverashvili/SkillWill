package com.example.GroupWork5.DTO.commentDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentRequest {

    @NotNull(message = "comment can not be null")
    @Size(min = 2, max = 128, message = "comment must between in 2-128")
    private String comment;

    // ------------------ Constructors --------------------
    public CommentRequest() {
    }

    public CommentRequest(String comment) {
        this.comment = comment;
    }

    // ----------------- Setters and Getters -------------------
    public @NotNull(message = "comment can not be null") @Size(min = 2, max = 128, message = "comment must between in 2-128") String getComment() {
        return comment;
    }

    public void setComment(@NotNull(message = "comment can not be null") @Size(min = 2, max = 128, message = "comment must between in 2-128") String comment) {
        this.comment = comment;
    }
}
