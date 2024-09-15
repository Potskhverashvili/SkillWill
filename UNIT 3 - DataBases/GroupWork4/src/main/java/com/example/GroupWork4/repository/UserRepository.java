package com.example.GroupWork4.repository;

import com.example.GroupWork4.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    @Transactional
    @Modifying
    @Query("""
                INSERT INTO Users (userName, firstName, lastName, birthdate)
                VALUES (:userName, :firstName, :lastName, :birthdate)
            """)
    void registerUser(String userName, String firstName, String lastName, LocalDate birthdate)
            throws DataIntegrityViolationException;

    @Transactional
    @Modifying
    @Query("""
         UPDATE Users
         SET firstName = :firstName,
             lastName = :lastName,
             birthdate = :birthdate
         WHERE userName = :userName
        """)
    Users updateUser(String userName, String firstName, String lastName, LocalDate birthdate);


}

