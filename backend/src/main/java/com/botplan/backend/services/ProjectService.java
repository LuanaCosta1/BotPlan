package com.botplan.backend.services;

import com.botplan.backend.dto.ProjectDTO;
import com.botplan.backend.entity.Project;
import com.botplan.backend.mapper.ProjectMapper;
import com.botplan.backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectDTO getProject(Long id){
        return ProjectMapper.toDto(projectRepository.findProjectById(id));
    }

    public ProjectDTO addProject(Project project){
        return ProjectMapper.toDto(projectRepository.save(project));
    }

    public List<ProjectDTO> getAllProjects(){
        return projectRepository.findAll().stream()
                .map(ProjectMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProjectDTO updateProject(Project project, Long id){
        Project entity = projectRepository.findProjectById(id);
        if (entity != null) {
            project.setId(entity.getId());
            return ProjectMapper.toDto(projectRepository.save(project));
        }
        return null;
    }

    public void deleteProject(Long id) {
        Project entity = projectRepository.findProjectById(id);
        projectRepository.delete(entity);
    }
}
