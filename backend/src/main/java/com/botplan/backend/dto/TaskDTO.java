package com.botplan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private String title;

    private String description;
    private String notes;
    private int points;
    private String state;
    private String priority;
    private String type;
    private String testerAssigned;
    private String creator;
    private Date creationDate;
    private Date conclusionDate;
    private Long idEmployee;
    private Long backupIdEmployee;
}
