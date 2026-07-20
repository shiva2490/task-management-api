package com.harij.taskmanager.service;
import com.harij.taskmanager.dto.CreateTaskRequest;
import com.harij.taskmanager.dto.DashboardResponse;
import com.harij.taskmanager.model.Task;
import com.harij.taskmanager.model.TaskStatus;
import com.harij.taskmanager.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceImplTest {

    private TaskServiceImpl taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskServiceImpl();
    }

    @Test
    void shouldCreateTask() {

        CreateTaskRequest request = new CreateTaskRequest();
        request.setTaskName("Learn Spring Boot");
        request.setDescription("Practice REST API");

        Task task = taskService.createTask(request);

        assertNotNull(task);
        assertEquals("Learn Spring Boot", task.getTaskName());
        assertEquals(TaskStatus.PENDING, task.getStatus());
    }

    @Test
    void shouldReturnAllTasks() {

        CreateTaskRequest request = new CreateTaskRequest();
        request.setTaskName("Task 1");
        request.setDescription("Demo");

        taskService.createTask(request);

        assertEquals(1, taskService.getAllTasks().size());
    }

    @Test
    void shouldUpdateTaskStatus() {

        CreateTaskRequest request = new CreateTaskRequest();
        request.setTaskName("Task");
        request.setDescription("Demo");

        Task task = taskService.createTask(request);

        Task updated = taskService.updateTaskStatus(task.getId());

        assertEquals(TaskStatus.COMPLETED, updated.getStatus());
    }

    @Test
    void shouldDeleteTask() {

        CreateTaskRequest request = new CreateTaskRequest();
        request.setTaskName("Task");
        request.setDescription("Demo");

        Task task = taskService.createTask(request);

        taskService.deleteTask(task.getId());

        assertTrue(taskService.getAllTasks().isEmpty());
    }

    @Test
    void shouldReturnDashboardSummary() {

        CreateTaskRequest request = new CreateTaskRequest();
        request.setTaskName("Task");
        request.setDescription("Demo");

        Task task = taskService.createTask(request);

        taskService.updateTaskStatus(task.getId());

        DashboardResponse dashboard = taskService.getDashboardSummary();

        assertEquals(1, dashboard.getTotalTasks());
        assertEquals(1, dashboard.getCompletedTasks());
        assertEquals(0, dashboard.getPendingTasks());
    }

}