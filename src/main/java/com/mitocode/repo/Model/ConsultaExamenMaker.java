package com.mitocode.repo.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsultaExamenMaker implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consulta consulta;
    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false)
    private Examen examen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaExamenMaker that = (ConsultaExamenMaker) o;
        return Objects.equals(consulta, that.consulta) && Objects.equals(examen, that.examen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consulta, examen);
    }
}
