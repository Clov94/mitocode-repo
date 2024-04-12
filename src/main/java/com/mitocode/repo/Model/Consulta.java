package com.mitocode.repo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "consulta")
public class Consulta extends RepresentationModel<Consulta> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idConsulta;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime fecha;

    @OneToMany(
            mappedBy = "consulta",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<DetalleConsulta> detalleConsulta;

}
