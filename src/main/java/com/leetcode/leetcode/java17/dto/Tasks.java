package com.leetcode.leetcode.java17.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

// Encapsulation with private fields and getters/setters
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null fields during serialization
public class Tasks {
    private Long id;
    private String name;
    private String type;     // e.g., Bug, Feature, Enhancement
    private String priority; // e.g., High, Medium, Low

    // Constructor for validation
    public Tasks(Long id, String name, String type, String priority) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Task name cannot be null or empty.");
        }
        this.id = id;
        this.name = name;
        this.type = type;
        this.priority = priority;
    }
}