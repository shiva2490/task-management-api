package com.harij.taskmanager.controller;

import com.harij.taskmanager.dto.CreateTaskRequest;
import com.harij.taskmanager.dto.DashboardResponse;
import com.harij.taskmanager.model.Task;
import com.harij.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Task> createTask(@Valid @RequestBody CreateTaskRequest request) {

        Task createdTask = taskService.createTask(request);

        // Return HTTP 201 with the created task
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    /**
     * Returns all available tasks.
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {

        // Get all tasks from service
        List<Task> tasks = taskService.getAllTasks();

        // Return HTTP 200 with task list
        return ResponseEntity.ok(tasks);
    }

    /**
     * Marks a task as completed.
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id) {

        // Delegate status update to service layer
        Task updatedTask = taskService.updateTaskStatus(id);

        // Return updated task
        return ResponseEntity.ok(updatedTask);
    }

    /**
     * Deletes a task by its ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        // Delegate delete operation to service layer
        taskService.deleteTask(id);

        // Return HTTP 204 No Content
        return ResponseEntity.noContent().build();
    }

    /**
     * Returns task dashboard summary.
     */
    @GetMapping("/dashboard")
    public ResponseEntity<DashboardResponse> getDashboardSummary() {

        // Get dashboard details from service
        DashboardResponse dashboard = taskService.getDashboardSummary();

        // Return dashboard response
        return ResponseEntity.ok(dashboard);
    }
}