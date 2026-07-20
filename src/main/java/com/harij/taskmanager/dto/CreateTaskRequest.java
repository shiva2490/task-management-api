package com.harij.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Request object used to create a new task.

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskRequest {

    // Task name entered by the user
    @NotBlank(message = "Task name is required")
    @Size(min = 3, max = 100, message = "Task name must be between 3 and 100 characters")
    private String taskName;

    // Optional task description
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
}
