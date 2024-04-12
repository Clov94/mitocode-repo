package com.mitocode.repo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_especialidad", nullable = false)
    private String id_especialidad;
    @Column(name = "especialidad", nullable = false)
    private String especialidad;
    @Column(name = "description", nullable = false)
    private String description;
}
