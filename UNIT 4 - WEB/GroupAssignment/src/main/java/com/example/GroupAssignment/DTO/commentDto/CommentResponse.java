package com.example.GroupAssignment.DTO.commentDto;

import lombok.*;


@Data
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private String comment;
    private Long ownerUserId;
    private Long forPostId;
}
