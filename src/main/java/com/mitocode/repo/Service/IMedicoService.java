package com.mitocode.repo.Service;

import com.mitocode.repo.Model.Medico;

import java.util.Optional;


public interface IMedicoService extends ICRUD<Medico> {
    Optional<Medico> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
