package com.botplan.backend.dto;

import com.botplan.backend.entity.Story;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SprintDTO {
    private Long sprintId;
    private String startDate;
    private String endDate;
    private String goal;
    private List<Story> stories;
}
