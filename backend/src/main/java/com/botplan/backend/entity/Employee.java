package com.botplan.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@Table(name="employees")
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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> taskList;
}
