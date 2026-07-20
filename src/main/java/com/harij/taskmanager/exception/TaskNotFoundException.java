package com.harij.taskmanager.exception;

/**
 * Thrown when the requested task does not exist.
 */
public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String message) {
        super(message);
    }

}