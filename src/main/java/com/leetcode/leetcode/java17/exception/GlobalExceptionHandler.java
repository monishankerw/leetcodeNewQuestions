package com.leetcode.leetcode.java17.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle Task Not Found Exception
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleTaskNotFound(TaskNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Task not found");
        errorResponse.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // Handle Validation Errors
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationException(IllegalArgumentException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Validation Error");
        errorResponse.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // Handle General Errors
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Server Error");
        errorResponse.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}