package com.botplan.backend.mapper;

import com.botplan.backend.dto.EmployeeDTO;
import com.botplan.backend.dto.StoryDTO;
import com.botplan.backend.entity.Employee;
import com.botplan.backend.entity.Story;

public class StoryMapper {
    public static Story toEntity(StoryDTO dto) {
        return Story.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .notes(dto.getNotes())
                .points(dto.getPoints())
                .state(dto.getState())
                .priority(dto.getPriority())
                .type(dto.getType())
                .testerAssigned(dto.getTesterAssigned())
                .creator(dto.getCreator())
                .creationDate(dto.getCreationDate())
                .conclusionDate(dto.getConclusionDate())
                .idEmployee(dto.getIdEmployee())
                .backupIdEmployee(dto.getBackupIdEmployee())
                .build();
    }

    public static StoryDTO toDto(Story entity) {
        return StoryDTO.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .notes(entity.getNotes())
                .points(entity.getPoints())
                .state(entity.getState())
                .priority(entity.getPriority())
                .type(entity.getType())
                .testerAssigned(entity.getTesterAssigned())
                .creator(entity.getCreator())
                .creationDate(entity.getCreationDate())
                .conclusionDate(entity.getConclusionDate())
                .idEmployee(entity.getIdEmployee())
                .backupIdEmployee(entity.getBackupIdEmployee())
                .build();
    }
}
