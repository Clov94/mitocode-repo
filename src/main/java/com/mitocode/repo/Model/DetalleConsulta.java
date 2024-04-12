package com.mitocode.repo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_consulta")
public class DetalleConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_detalle_consulta")
    private String idDetalleConsulta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;

    @Column(name = "sintomas")
    private String sintomas;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "tratamiento")
    private String tratamiento;

}