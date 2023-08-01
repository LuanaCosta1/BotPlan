package com.backend.BotPlan.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column(nullable = false)
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
