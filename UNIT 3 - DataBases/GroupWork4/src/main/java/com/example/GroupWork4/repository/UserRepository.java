package com.example.GroupWork4.repository;

import com.example.GroupWork4.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {


    @Transactional
    @Modifying
    @Query("""
                INSERT INTO Users (userName, firstName, lastName, birthdate)
                VALUES (:userName, :firstName, :lastName, :birthdate)
            """)
    Integer registerUser(String userName, String firstName, String lastName, LocalDate birthdate);

}

