package com.botplan.backend.mapper;

import com.botplan.backend.dto.SprintDTO;
import com.botplan.backend.dto.SprintStoriesDTO;
import com.botplan.backend.entity.Sprint;

import java.util.stream.Collectors;

public class SprintMapper {

    public static Sprint toEntity(SprintDTO dto) {
        return Sprint.builder()
                .sprintId(dto.getSprintId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .goal(dto.getGoal())
                .build();
}

    public static SprintStoriesDTO toSprintStoriesDto(Sprint entity) {
        return SprintStoriesDTO.builder()
                .sprintId(entity.getSprintId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .goal(entity.getGoal())
                .stories(entity.getStories().stream().map(StoryMapper::toDto).collect(Collectors.toList()))
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
