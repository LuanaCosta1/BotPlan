package com.botplan.backend.dto;

import com.botplan.backend.entity.Sprint;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class ProjectDTO {
    private String projectName;
    private String projectDescription;
    private Date startDate;
    private Date endDate;
    private String projectManager;
    private List<Long> employeesListId;
    private List<String> technologiesUsed;
    private String status;
    private List<Sprint> sprints;
}
