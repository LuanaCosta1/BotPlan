package com.botplan.backend.mapper;

import com.botplan.backend.dto.SprintDTO;
import com.botplan.backend.entity.Sprint;

public class SprintMapper {

    public static Sprint toEntity(SprintDTO dto) {
        return Sprint.builder()
                .sprintId(dto.getSprintId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .goal(dto.getGoal())
                .build();
}

    public static SprintDTO toDto(Sprint entity) {
        return SprintDTO.builder()
                .sprintId(entity.getSprintId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .goal(entity.getGoal())
                .build();
    }
}
