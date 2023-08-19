package com.botplan.backend.dto;

import com.botplan.backend.entity.Project;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class EmployeeDTO {
    private String name;
    private String picture;
    private String stack;
    private List<String> technologies;
    private String seniority;
    private boolean admin;
    private String type;
    private boolean isWorking;
    private String reasonWhyNotWorking;
    private List<Integer> taskAssigned;

    private List<Project> projects;
}
