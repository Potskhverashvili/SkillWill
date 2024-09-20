/*
package com.example.GroupAssignment.repository;

import com.example.GroupAssignment.DTO.comentDto.ViewComment;
import com.example.GroupAssignment.model.CommentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM CommentEntity c WHERE c.postEntity.id = :postId")
    void deleteCommentByPostId(Long postId);

    @Query(value = """
            select new com.example.GroupWork5.DTO.commentDto.ViewComment(c.id, c.comment, c.postEntity.id, c.postEntity.userEntity.id)
            from CommentEntity c
            """,
            nativeQuery = false)
    Page<ViewComment> findAllComment(Pageable pageable);
}
*/
