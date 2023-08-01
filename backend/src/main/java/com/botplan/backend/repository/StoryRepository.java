package com.botplan.backend.repository;

import com.botplan.backend.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
    Story findByIdTask(Long idTask);
}
