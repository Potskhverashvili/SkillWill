package com.example.GroupAssignment.DTO.commentDto;

import lombok.*;

@Data
@AllArgsConstructor
public class ViewComment {
    private Long commentId;
    private String comment;
    private Long forPostId;
    private Long ownerUserId;
}
