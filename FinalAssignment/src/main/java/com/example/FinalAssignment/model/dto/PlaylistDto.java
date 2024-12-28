package com.example.FinalAssignment.model.dto;

import com.example.FinalAssignment.model.domain.database.UserEntity;
import lombok.Data;

@Data
public class PlaylistDto {
    private String name;
    private UserEntity userEntity;
}
