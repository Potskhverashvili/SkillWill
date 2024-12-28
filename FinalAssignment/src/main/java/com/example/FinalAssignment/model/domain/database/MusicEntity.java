package com.example.FinalAssignment.model.domain.database;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "music_entity")
@Setter
@Getter
@RequiredArgsConstructor
public class MusicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String musicName;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn(name = "music_album_entity")
    private AlbumEntity musicAlbumEntity;
}