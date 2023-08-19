package com.botplan.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Table(name="clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private String clientName;
    private String contactPerson;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "client")
    private List<Project> projects;
}
