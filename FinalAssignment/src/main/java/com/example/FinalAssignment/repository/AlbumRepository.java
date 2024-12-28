package com.example.FinalAssignment.repository;

import com.example.FinalAssignment.model.domain.database.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository  extends JpaRepository<AlbumEntity, Long> {
    List<AlbumEntity> findAllByUserEntityId(Long userId);
}
