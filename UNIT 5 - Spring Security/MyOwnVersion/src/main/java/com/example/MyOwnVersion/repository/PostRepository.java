package com.example.MyOwnVersion.repository;


import com.example.MyOwnVersion.dto.view.ViewPost;
import com.example.MyOwnVersion.model.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Query("""
            select new com.example.MyOwnVersion.dto.view.ViewPost(p.id, p.text, p.userEntity.id) from PostEntity p
            where p.userEntity.id = :userId
            """)
    Page<ViewPost> findAllPostOfUser(Long userId, Pageable pageable);

    @Query("""
            select new com.example.MyOwnVersion.dto.view.ViewPost(p.id, p.text, p.userEntity.id) from PostEntity p
            """)
    Page<ViewPost> findAllPost(Pageable pageable);

}
