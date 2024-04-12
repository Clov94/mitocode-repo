package com.mitocode.repo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_medico", nullable = false)
    private String id_medico;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "cmp", nullable = false)
    private String cmp;
}
