package com.botplan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String name;
    private String picture;
    private String stack;
    private String technologies;
    private String seniority;
    private boolean admin;
    private String type;
    private boolean isWorking;
    private String reasonWhyNotWorking;
    private String taskAssigned;
}
