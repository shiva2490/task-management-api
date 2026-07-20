package com.harij.taskmanager.controller;

import com.harij.taskmanager.dto.CreateTaskRequest;
import com.harij.taskmanager.model.Task;
import com.harij.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes REST APIs for task management.
 */
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    // Business logic is delegated to the service layer
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskRequest request) {

        Task createdTask = taskService.createTask(request);

        // Return HTTP 201 with the created task
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
}