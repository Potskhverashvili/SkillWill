package com.example.ExceptionsExtracurricularAssignment.service;

import com.example.ExceptionsExtracurricularAssignment.exception.CustomException;
import com.example.ExceptionsExtracurricularAssignment.exception.ErrorMessages;
import com.example.ExceptionsExtracurricularAssignment.model.TaskEntity;
import com.example.ExceptionsExtracurricularAssignment.repository.TaskRepository;
import com.example.ExceptionsExtracurricularAssignment.taskDto.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }

    // -------------------------- Create Task ----------------------------

    public TaskEntity crateTask(TaskDto task){
        TaskEntity save = new TaskEntity();
        save.setTitle(task.getTitle());
        save.setDescription(task.getDescription());
        return taskRepository.save(save);
    }
    // --------------------------- View Task -------------------------------

    public List<TaskEntity> viewAllTask(){
        if (taskRepository.findAll().isEmpty())
            throw new CustomException(ErrorMessages.NOT_FOUND);
        return taskRepository.findAll();
    }
}
