package com.leetcode.leetcode.java17.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.leetcode.leetcode.java17.dto.TaskDTO;
import com.leetcode.leetcode.java17.dto.Tasks;
import com.leetcode.leetcode.java17.entity.Task;
import com.leetcode.leetcode.java17.exception.TaskNotFoundException;
import com.leetcode.leetcode.java17.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Create or Update Task
    public TaskDTO saveTask(TaskDTO taskDTO) {
        validateTaskDTO(taskDTO);
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setType(taskDTO.getType());
        task.setPriority(taskDTO.getPriority());
        task = taskRepository.save(task);
        return mapToDTO(task);
    }

    // Get All Tasks
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get Task By ID
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found."));
        return mapToDTO(task);
    }

    // Delete Task
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found.");
        }
        taskRepository.deleteById(id);
    }

    // Process Task Message with Validation and Null Handling
    public String getTaskMessage(TaskDTO taskDTO) {
        validateTaskDTO(taskDTO);
        return switch (taskDTO.getType().toLowerCase()) {
            case "bug" -> switch (taskDTO.getPriority().toLowerCase()) {
                case "high" -> "Critical bug! Immediate attention required.";
                case "medium" -> "Bug needs to be fixed soon.";
                case "low" -> "Minor bug. Can be fixed later.";
                default -> "Unknown bug priority.";
            };
            case "feature" -> switch (taskDTO.getPriority().toLowerCase()) {
                case "high" -> "Feature requires urgent development.";
                case "medium" -> "Feature is in the development queue.";
                case "low" -> "Feature request logged.";
                default -> "Unknown feature priority.";
            };
            case "enhancement" -> switch (taskDTO.getPriority().toLowerCase()) {
                case "high" -> "Important enhancement for product improvement.";
                case "medium" -> "Enhancement planned for future release.";
                case "low" -> "Enhancement added to backlog.";
                default -> "Unknown enhancement priority.";
            };
            default -> "Unknown task type.";
        };
    }

    // Serialize Task to JSON
    public String serializeTask(Tasks tasks) {
        try {
            if (tasks == null) {
                throw new IllegalArgumentException("Task cannot be null.");
            }
            return objectMapper.writeValueAsString(tasks);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing Task object to JSON: " + e.getMessage());
        }
    }

    // Deserialize JSON to Task
    public Tasks deserializeTask(String json) {
        try {
            if (json == null || json.isBlank()) {
                throw new IllegalArgumentException("Input JSON cannot be null or empty.");
            }
            return objectMapper.readValue(json, Tasks.class);
        } catch (InvalidFormatException e) {
            throw new RuntimeException("Error parsing JSON: Invalid data format.");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing JSON to Task: " + e.getMessage());
        }
    }

    // Utility Method to Map Entity to DTO
    private TaskDTO mapToDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setType(task.getType());
        dto.setPriority(task.getPriority());
        return dto;
    }

    // Validate Task DTO
    private void validateTaskDTO(TaskDTO taskDTO) {
        if (taskDTO == null) {
            throw new IllegalArgumentException("TaskDTO cannot be null.");
        }
        if (taskDTO.getName() == null || taskDTO.getName().isBlank()) {
            throw new IllegalArgumentException("Task name cannot be null or blank.");
        }
        if (taskDTO.getType() == null || taskDTO.getType().isBlank()) {
            throw new IllegalArgumentException("Task type cannot be null or blank.");
        }
        if (taskDTO.getPriority() == null || taskDTO.getPriority().isBlank()) {
            throw new IllegalArgumentException("Task priority cannot be null or blank.");
        }
    }
}