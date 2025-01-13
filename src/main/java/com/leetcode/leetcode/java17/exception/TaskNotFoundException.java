package com.leetcode.leetcode.java17.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}