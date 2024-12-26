package com.example.FinalAssignment.model.domain.database;


import com.example.FinalAssignment.model.enums.AlbumStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity()
@Table(name = "album")
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "album_name", nullable = false)
    private String albumName;

    @OneToMany(mappedBy = "musicAlbumEntity")
    private Set<MusicEntity> music;

    @Column(name = "album_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AlbumStatus albumStatus;

    /*@ManyToOne()
    @Column(name = "ownerId")
    private UserEntity userEntity;*/

}
