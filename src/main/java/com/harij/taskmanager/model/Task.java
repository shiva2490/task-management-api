package com.harij.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Represents a task in the application.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    // Unique ID for each task
    private Long id;

    // Name entered by the user
    private String taskName;

    // Optional description
    private String description;

    // Current task status
    private TaskStatus status;

    // Date and time when the task was created
    private LocalDateTime createdDate;
}