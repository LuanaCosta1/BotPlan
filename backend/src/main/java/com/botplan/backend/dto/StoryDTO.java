package com.botplan.backend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class StoryDTO {
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
