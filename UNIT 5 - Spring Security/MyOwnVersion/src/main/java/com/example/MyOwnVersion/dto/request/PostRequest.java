package com.example.MyOwnVersion.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostRequest {
    @NotNull(message = "text can not be null")
    @Size(min = 2, max = 512, message = "text must be between 2-512")
    private String text;
}

