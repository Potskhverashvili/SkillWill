package com.example.GroupWork5.DTO.postDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostRequest {

    @NotNull(message = "text can not be null")
    @Size(min = 2, max = 512, message = "text must be between 2-512")
    private String text;

    // ----------------- Constructors ---------------------
    public PostRequest() {
    }

    public PostRequest(String text) {
        this.text = text;
    }

    // --------------- Setters and Getters ----------------
    public @NotNull(message = "text can not be null") @Size(min = 2, max = 512, message = "text must be between 2-512") String getText() {
        return text;
    }

    public void setText(@NotNull(message = "text can not be null") @Size(min = 2, max = 512, message = "text must be between 2-512") String text) {
        this.text = text;
    }
}
