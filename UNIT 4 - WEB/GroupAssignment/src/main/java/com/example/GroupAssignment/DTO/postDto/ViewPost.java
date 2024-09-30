package com.example.GroupAssignment.DTO.postDto;

import lombok.*;

@Data
@AllArgsConstructor
public class ViewPost {
    private Long postId;
    private String text;
    private Long ownerUserId;
}
