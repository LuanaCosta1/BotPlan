package com.botplan.backend.controller;

import com.botplan.backend.dto.ProjectDTO;
import com.botplan.backend.entity.Project;
import com.botplan.backend.response.BaseResponse;
import com.botplan.backend.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/")
    public BaseResponse<ProjectDTO> add(@RequestBody Project project) {
        ProjectDTO savedProject = projectService.addProject(project);
        return BaseResponse.<ProjectDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(savedProject)
                .build();
    }

    @GetMapping("/")
    public BaseResponse<List<ProjectDTO>> selectAll() {
        List<ProjectDTO> allProjects = projectService.getAllProjects();
        return BaseResponse.<List<ProjectDTO>>builder()
                .httpCode(200)
                .message("OK")
                .response(allProjects)
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<ProjectDTO> getProject(@PathVariable("id") Long id) {
        ProjectDTO projectDTO = projectService.getProject(id);
        return BaseResponse.<ProjectDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(projectDTO)
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<ProjectDTO> update(@RequestBody Project project, @PathVariable("id") Long id) {
        ProjectDTO updatedProject = projectService.updateProject(project, id);
        return BaseResponse.<ProjectDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(updatedProject)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
