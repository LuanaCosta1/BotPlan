package com.botplan.repository;

import com.botplan.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task getById(Long id);
}
