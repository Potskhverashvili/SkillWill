package com.example.ExceptionsExtracurricularAssignment.repository;

import com.example.ExceptionsExtracurricularAssignment.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
