package com.example.MyOwnVersion.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentRequest {
    @NotNull(message = "comment can not be null")
    @Size(min = 2, max = 128, message = "comment must between in 2-128")
    private String comment;
}