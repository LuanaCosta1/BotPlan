package com.botplan.backend.mapper;


import com.botplan.backend.dto.StoryDTO;
import com.botplan.backend.entity.Story;

public class StoryMapper {
    public static Story toEntity(StoryDTO dto) {
        return Story.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .notes(dto.getNotes())
                .points(dto.getPoints())
                .priority(dto.getPriority())
                .type(dto.getType())
                .creator(dto.getCreator())
                .creationDate(dto.getCreationDate())
                .state(dto.getState())
                .testerAssigned(dto.getTesterAssigned())
                .conclusionDate(dto.getConclusionDate())
                .employee(dto.getEmployee())
                .backupEmployee(dto.getBackupEmployee())
                .build();
    }

    public static StoryDTO toDto(Story entity) {
        return StoryDTO.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .notes(entity.getNotes())
                .points(entity.getPoints())
                .priority(entity.getPriority())
                .type(entity.getType())
                .creator(entity.getCreator())
                .creationDate(entity.getCreationDate())
                .state(entity.getState())
                .testerAssigned(entity.getTesterAssigned())
                .conclusionDate(entity.getConclusionDate())
                .employee(entity.getEmployee())
                .backupEmployee(entity.getBackupEmployee())
                .build();
    }
}
