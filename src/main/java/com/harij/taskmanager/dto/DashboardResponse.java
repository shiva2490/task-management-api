package com.harij.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents dashboard summary information.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    // Total number of tasks
    private long totalTasks;

    // Number of completed tasks
    private long completedTasks;

    // Number of pending tasks
    private long pendingTasks;

}