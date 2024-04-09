package com.mitocode.repo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_role", nullable = false)
    private String id_role;
    @Column(name = "role", nullable = false)
    private String role;
    @Column(name = "description", nullable = false)
    private String description;
}
