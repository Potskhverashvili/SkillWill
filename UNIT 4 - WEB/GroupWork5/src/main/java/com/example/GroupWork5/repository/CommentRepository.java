package com.example.GroupWork5.repository;

import com.example.GroupWork5.DTO.commentDto.ViewComment;
import com.example.GroupWork5.model.CommentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
