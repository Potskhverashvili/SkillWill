package com.example.GroupWork5.DTO.commentDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentResponse {

    @NotBlank(message = "Id can not be null")
    private Long id;

    @NotNull(message = "comment can not be null")
    @Size(min = 2, max = 128, message = "comment must between in 2-128")
    private String comment;

    // ----------------- Constructors -----------------------
    public CommentResponse() {
    }

    public CommentResponse(String comment, Long id) {
        this.comment = comment;
        this.id = id;
    }

    // ---------------------- Setters and Getters ----------------------
    public @NotNull(message = "comment can not be null") @Size(min = 2, max = 128, message = "comment must between in 2-128") String getComment() {
        return comment;
    }

    public void setComment(@NotNull(message = "comment can not be null") @Size(min = 2, max = 128, message = "comment must between in 2-128") String comment) {
        this.comment = comment;
    }

    public @NotBlank(message = "Id can not be null") Long getId() {
        return id;
    }

    public void setId(@NotBlank(message = "Id can not be null") Long id) {
        this.id = id;
    }
}
