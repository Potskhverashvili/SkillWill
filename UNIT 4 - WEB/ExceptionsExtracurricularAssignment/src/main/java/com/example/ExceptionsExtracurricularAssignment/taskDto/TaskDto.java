package com.example.ExceptionsExtracurricularAssignment.taskDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskDto {

    @NotBlank(message = "title can not be null")
    private String title;

    @NotBlank(message = "description can not be null")
    private String description;
}
