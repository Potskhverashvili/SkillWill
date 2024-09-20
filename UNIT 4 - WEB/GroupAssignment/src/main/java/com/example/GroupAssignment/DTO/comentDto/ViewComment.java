package com.example.GroupAssignment.DTO.comentDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewComment {
    private Long commentId;
    private String comment;
    private Long ownerUserId;
    private Long forPostId;
}
