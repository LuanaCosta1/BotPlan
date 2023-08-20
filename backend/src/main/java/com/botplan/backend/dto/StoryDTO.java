package com.botplan.backend.dto;

import com.botplan.backend.entity.Employee;
import com.botplan.backend.entity.Sprint;
import com.botplan.backend.entity.Story;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private SprintDTO sprint;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "backup_id_employee")
    private Employee backupEmployee;
}
