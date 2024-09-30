package com.example.GroupAssignment.repository;

import com.example.GroupAssignment.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName")
    Optional<UserEntity> findUserByUserName(String userName);

    /*@Query("SELECT 1 FROM UserEntity WHERE id= :id")
    boolean existsById(Long id);*/

}
