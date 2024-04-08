package com.mitocode.repo.consultorio.Service;

import com.mitocode.repo.consultorio.Model.Medico;

import java.util.Optional;


public interface IMedicoService extends ICRUD<Medico> {
    Optional<Medico> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
