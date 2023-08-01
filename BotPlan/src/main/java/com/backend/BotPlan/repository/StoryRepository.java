package com.backend.BotPlan.repository;

import com.backend.BotPlan.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
    Story findByIdTask(Long idTask);
}
