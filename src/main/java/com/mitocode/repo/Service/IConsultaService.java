package com.mitocode.repo.Service;

import com.mitocode.repo.Model.Consulta;

import java.util.Optional;

public interface IConsultaService extends ICRUD<Consulta> {

//   ConsultaDto transactionalSave(ConsultaDto consulta);

    Optional<Consulta> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
