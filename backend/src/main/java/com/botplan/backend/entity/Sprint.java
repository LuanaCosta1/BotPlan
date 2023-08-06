package com.botplan.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Table(name="sprints")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {

    @Id
    private Long sprintId;
    private String startDate;
    private String endDate;
    private String goal;
    private List<Story> stories;
}