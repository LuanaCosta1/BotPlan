package com.botplan.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String notes;

    @NotNull
    private int points;

    @NotNull
    private String state;

    @NotNull
    private String priority;

    @NotNull
    private String type;

    @NotNull
    private String testerAssigned;

    @NotNull
    private String creator;

    @NotNull
    private Date creationDate;

    @NotNull
    private Date conclusionDate;

    @NotNull
    private Long idEmployee;

    @NotNull
    private Long backupIdEmployee;
}
