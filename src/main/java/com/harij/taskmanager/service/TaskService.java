package com.harij.taskmanager.service;

import com.harij.taskmanager.dto.CreateTaskRequest;
import com.harij.taskmanager.model.Task;

import java.util.List;

/**
 * Defines all business operations related to tasks.
 */
public interface TaskService {

    /**
     * Creates a new task.
     */
    Task createTask(CreateTaskRequest request);

    /**
     * Returns all available tasks.
     */
    List<Task> getAllTasks();

    /**
     * Marks a task as completed.
     */
    Task updateTaskStatus(Long id);

    /**
     * Deletes a task by ID.
     */
    void deleteTask(Long id);

}