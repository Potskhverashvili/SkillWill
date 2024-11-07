package com.example.MyOwnVersion.dto.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewComment {
    private Long commentId;
    private String comment;
    private Long forPostId;
    private Long ownerUserId;
}