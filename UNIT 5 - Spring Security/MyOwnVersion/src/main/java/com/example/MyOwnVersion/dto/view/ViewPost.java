package com.example.MyOwnVersion.dto.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewPost {
    private Long postId;
    private String text;
    private Long ownerUserId;
}
