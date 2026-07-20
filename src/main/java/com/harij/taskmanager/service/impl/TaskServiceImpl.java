package com.harij.taskmanager.service.impl;

import com.harij.taskmanager.dto.CreateTaskRequest;
import com.harij.taskmanager.dto.DashboardResponse;
import com.harij.taskmanager.exception.TaskNotFoundException;
import com.harij.taskmanager.model.Task;
import com.harij.taskmanager.model.TaskStatus;
import com.harij.taskmanager.service.TaskService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    // Stores all tasks in memory
    private final List<Task> tasks = new ArrayList<>();

    // Generates unique IDs
    private Long nextId = 1L;

    /**
     * Loads sample tasks when the application starts.
     */
    @PostConstruct
    public void loadSampleTasks() {

        tasks.add(new Task(
                nextId++,
                "Learn Spring Boot",
                "Complete REST API assignment",
                TaskStatus.PENDING,
                LocalDateTime.now()
        ));

        tasks.add(new Task(
                nextId++,
                "Practice Angular",
                "Prepare UI screens",
                TaskStatus.COMPLETED,
                LocalDateTime.now()
        ));
    }

    @Override
    public Task createTask(CreateTaskRequest request) {

        // Create a new task object
        Task task = new Task(
                nextId++,
                request.getTaskName(),
                request.getDescription(),
                TaskStatus.PENDING,
                LocalDateTime.now()
        );

        // Store task in memory
        tasks.add(task);

        // Return created task
        return task;
    }

    @Override
    public List<Task> getAllTasks() {

        // Return a copy of all tasks
        return new ArrayList<>(tasks);
    }

    @Override
    public Task updateTaskStatus(Long id) {
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id : " + id));

        // Update the task status
        task.setStatus(TaskStatus.COMPLETED);

        //Return updated task
        return task;
    }

    @Override
    public void deleteTask(Long id) {

        // Remove task if ID matches
        boolean removed = tasks.removeIf(t -> t.getId().equals(id));

        // Throw exception if task not found
        if (!removed) {
            throw new TaskNotFoundException("Task not found with id : " + id);
        }
    }

    @Override
    public DashboardResponse getDashboardSummary() {

        // Count all tasks
        long totalTasks = tasks.stream().count();

        // Count completed tasks
        long completedTasks = tasks.stream()
                .filter(task -> task.getStatus() == TaskStatus.COMPLETED)
                .count();

        // Remaining tasks are pending
        long pendingTasks = totalTasks - completedTasks;

        // Return dashboard summary
        return new DashboardResponse(
                totalTasks,
                completedTasks,
                pendingTasks
        );
    }
}