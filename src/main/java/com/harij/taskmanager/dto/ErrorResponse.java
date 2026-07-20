package com.harij.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Standard error response returned to the client.
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    // Time when the error occurred
    private LocalDateTime timestamp;

    // HTTP status code
    private int status;

    // Error message
    private String message;

    // Validation errors (field -> message)
    private Map<String, String> errors;

}