package com.example.GroupWork5.DTO.postDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostResponse {
    @NotBlank(message = "Id can not be null")
    private Long id;

    @NotNull(message = "text can not be null")
    @Size(min = 2, max = 512, message = "text must be between 2-512")
    private String text;

    // --------------- Constructors --------------------
    public PostResponse() {
    }

    public PostResponse(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    // -------------- Setters and Getters -----------------

    public @NotBlank(message = "Id can not be null") Long getId() {
        return id;
    }

    public void setId(@NotBlank(message = "Id can not be null") Long id) {
        this.id = id;
    }

    public @NotNull(message = "text can not be null") @Size(min = 2, max = 512, message = "text must be between 2-512") String getText() {
        return text;
    }

    public void setText(@NotNull(message = "text can not be null") @Size(min = 2, max = 512, message = "text must be between 2-512") String text) {
        this.text = text;
    }
}
