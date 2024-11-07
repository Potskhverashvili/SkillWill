package com.example.MyOwnVersion.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private String comment;
    private Long ownerUserId;
    private Long forPostId;
}

