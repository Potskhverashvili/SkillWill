package com.example.FinalAssignment.repository;

import com.example.FinalAssignment.model.domain.database.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository  extends JpaRepository<AlbumEntity, Long> {
}
