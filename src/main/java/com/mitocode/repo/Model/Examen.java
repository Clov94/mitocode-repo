package com.mitocode.repo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Examen examen)) return false;
        return Objects.equals(getId_examen(), examen.getId_examen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_examen());
    }
}
