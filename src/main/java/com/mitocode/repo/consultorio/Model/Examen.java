package com.mitocode.repo.consultorio.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "examen")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_examen", nullable = false)
    private String id_examen;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
}
