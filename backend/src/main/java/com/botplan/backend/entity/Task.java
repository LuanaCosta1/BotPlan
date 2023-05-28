package com.botplan.entity;

import com.botplan.mapper.EmployeeMapper;
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
    private Long idTask;

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
    private Long idEmployee;
    private Long backupIdEmployee;

    public void addEmployee(Employee employee) {
        setEmployee(employee);
        employee.getTaskList().add(this);
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
