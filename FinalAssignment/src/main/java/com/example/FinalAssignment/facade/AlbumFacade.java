package com.example.FinalAssignment.facade;

import com.example.FinalAssignment.model.domain.database.AlbumEntity;
import com.example.FinalAssignment.model.dto.AlbumDto;
import com.example.FinalAssignment.model.enums.AlbumStatus;
import com.example.FinalAssignment.model.mapper.AlbumMapper;
import com.example.FinalAssignment.model.param.AddAlbumParam;
import com.example.FinalAssignment.security.AddAlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AlbumFacade {

    private final AddAlbumService albumService;

    // ------------------------------- Add Album --------------------------------
    public AlbumDto addAlbum(AddAlbumParam addAlbumParam) {
        AlbumEntity album = new AlbumEntity();
        album.setAlbumName(addAlbumParam.getAlbumName());
        album.setAlbumStatus(AlbumStatus.ACTIVE);
        albumService.saveAlbum(album);
        return AlbumMapper.toAlbumDto(album);
    }
}
