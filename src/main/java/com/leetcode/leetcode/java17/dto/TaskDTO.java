package com.leetcode.leetcode.java17.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private Long id;
    private String name;
    private String type;
    private String priority;
}