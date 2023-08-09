package com.botplan.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Table(name="employees")
@Getter
@Setter
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
    private List<String> technologies;
    private String seniority;
    private boolean admin;
    private String type;
    private boolean isWorking;
    private String reasonWhyNotWorking;
    private List<Integer> taskAssigned;
}
