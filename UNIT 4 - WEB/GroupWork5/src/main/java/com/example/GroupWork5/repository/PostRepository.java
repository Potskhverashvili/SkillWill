package com.example.GroupWork5.repository;

import com.example.GroupWork5.DTO.postDto.ViewPost;
import com.example.GroupWork5.model.PostEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Query("""
            select new com.example.GroupWork5.DTO.postDto.ViewPost(p.id, p.text, p.userEntity.userName) from PostEntity p
            where p.userEntity.id = :userId
            """)
    Page<ViewPost> findAllPostOfUser(Long userId, Pageable pageable);

    @Query("""
        select new com.example.GroupWork5.DTO.postDto.ViewPost(p.id, p.text, p.userEntity.userName) from PostEntity p
        """)
    Page<ViewPost> findAllPost(Pageable pageable);
}
