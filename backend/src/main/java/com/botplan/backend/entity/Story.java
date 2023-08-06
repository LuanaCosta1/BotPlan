package com.botplan.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@Table(name="stories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;

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
