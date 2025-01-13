package com.leetcode.leetcode.java17.controller;


import com.leetcode.leetcode.java17.dto.TaskDTO;
import com.leetcode.leetcode.java17.dto.Tasks;
import com.leetcode.leetcode.java17.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.saveTask(taskDTO);
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/process")
    public String processTask(@RequestBody TaskDTO taskDTO) {
        return taskService.getTaskMessage(taskDTO);
    }

    @PostMapping("/serialize")
    public String serializeTask(@RequestBody Tasks tasks) {
        return taskService.serializeTask(tasks);
    }

    @PostMapping("/deserialize")
    public Tasks deserializeTask(@RequestBody String json) {
        return taskService.deserializeTask(json);
    }
}