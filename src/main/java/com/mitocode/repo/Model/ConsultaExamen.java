package com.mitocode.repo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@SuppressWarnings("ALL")
@Entity
@Data
@IdClass(ConsultaExamenMaker.class)
public class ConsultaExamen {
    @Id
    private Consulta consulta;
    @Id
    private Examen examen;
}
