package com.example.ExceptionsExtracurricularAssignment.controller;

import com.example.ExceptionsExtracurricularAssignment.model.TaskEntity;
import com.example.ExceptionsExtracurricularAssignment.service.TaskService;
import com.example.ExceptionsExtracurricularAssignment.taskDto.TaskDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public TaskEntity create(@RequestBody @Valid TaskDto task){
        return taskService.crateTask(task);
    }


    @GetMapping("/view-all")
    public List<TaskEntity> viewAllTask(){
        return taskService.viewAllTask();
    }
}
