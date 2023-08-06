package com.botplan.backend.controller;

import com.botplan.backend.dto.SprintDTO;
import com.botplan.backend.entity.Sprint;
import com.botplan.backend.response.BaseResponse;
import com.botplan.backend.services.SprintService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("sprints")
@CrossOrigin(origins = "*")
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @PostMapping("/")
    public BaseResponse<SprintDTO> add(@RequestBody Sprint sprint) {
        SprintDTO savedSprint = sprintService.addSprint(sprint);
        return BaseResponse.<SprintDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(savedSprint)
                .build();
    }

    @GetMapping("/")
    public BaseResponse<List<SprintDTO>> selectAll() {
        List<SprintDTO> allSprints = sprintService.getAllSprints();
        return BaseResponse.<List<SprintDTO>>builder()
                .httpCode(200)
                .message("OK")
                .response(allSprints)
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<SprintDTO> getSprint(@PathVariable("id") Long id) {
        SprintDTO sprintDTO = sprintService.getSprint(id);
        return BaseResponse.<SprintDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(sprintDTO)
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<SprintDTO> update(@RequestBody Sprint sprint, @PathVariable("id") Long id) {
        SprintDTO updatedSprint = sprintService.updateSprint(sprint, id);
        return BaseResponse.<SprintDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(updatedSprint)
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        sprintService.deleteSprint(id);
    }
}