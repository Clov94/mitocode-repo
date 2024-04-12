package com.mitocode.repo.DTO;

import com.mitocode.repo.Model.Consulta;
import com.mitocode.repo.Model.Examen;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class ConsultaDto extends RepresentationModel<ConsultaDto> {
    private Consulta consulta;
    private List<Examen> examenes;
}
