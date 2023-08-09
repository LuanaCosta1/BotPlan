package com.botplan.backend.mapper;

import com.botplan.backend.dto.ProjectDTO;
import com.botplan.backend.entity.Project;

public class ProjectMapper {
    public static Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setProjectName(dto.getProjectName());
        project.setProjectDescription(dto.getProjectDescription());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setProjectManager(dto.getProjectManager());
        project.setEmployeesListId(dto.getEmployeesListId());
        project.setTechnologiesUsed(dto.getTechnologiesUsed());
        project.setStatus(dto.getStatus());
        project.setSprints(dto.getSprints());
        return project;
    }

    public static ProjectDTO toDto(Project entity) {
        return ProjectDTO.builder()
                .projectName(entity.getProjectName())
                .projectDescription(entity.getProjectDescription())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .projectManager(entity.getProjectManager())
                .employeesListId(entity.getEmployeesListId())
                .technologiesUsed(entity.getTechnologiesUsed())
                .status(entity.getStatus())
                .sprints(entity.getSprints())
                .build();
    }

}
