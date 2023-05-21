package com.botplan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Builder
@Table(name="tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTask;

    @Column(nullable = false)
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

    private int idEmployee;

    private int backupIdEmployee;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
