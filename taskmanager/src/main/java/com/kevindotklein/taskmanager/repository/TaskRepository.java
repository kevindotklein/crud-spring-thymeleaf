package com.kevindotklein.taskmanager.repository;

import com.kevindotklein.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
