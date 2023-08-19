package com.botplan.backend.dto;

import com.botplan.backend.entity.Employee;
import jakarta.persistence.*;
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
    private String priority;
    private String type;
    private String creator;
    private Date creationDate;
    private String state;
    private String testerAssigned;
    private Date conclusionDate;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "backup_id_employee")
    private Employee backupEmployee;
}
