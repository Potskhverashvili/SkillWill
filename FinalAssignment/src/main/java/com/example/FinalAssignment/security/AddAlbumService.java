package com.example.FinalAssignment.security;

import com.example.FinalAssignment.model.domain.database.AlbumEntity;
import com.example.FinalAssignment.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddAlbumService {
    private final AlbumRepository albumRepository;

    @Transactional
    public AlbumEntity saveAlbum(AlbumEntity album) {
        return albumRepository.saveAndFlush(album);
    }
}
