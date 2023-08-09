package com.botplan.backend.repository;

import com.botplan.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {
    Project findProjectById(Long id);
}
