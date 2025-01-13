package com.leetcode.leetcode.java17.repository;

import com.leetcode.leetcode.java17.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}