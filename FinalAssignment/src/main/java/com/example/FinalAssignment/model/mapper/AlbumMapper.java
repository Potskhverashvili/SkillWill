package com.example.FinalAssignment.model.mapper;

import com.example.FinalAssignment.model.domain.database.AlbumEntity;
import com.example.FinalAssignment.model.dto.AlbumDto;

public class AlbumMapper {

    public static AlbumDto toAlbumDto(AlbumEntity albumEntity) {
        return new AlbumDto(
                albumEntity.getAlbumName(),
                albumEntity.getAlbumStatus()
        );
    }
}