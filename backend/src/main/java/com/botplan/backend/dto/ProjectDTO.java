package com.botplan.backend.dto;

import com.botplan.backend.entity.Sprint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
