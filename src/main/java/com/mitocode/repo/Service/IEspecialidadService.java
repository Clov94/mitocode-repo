package com.mitocode.repo.Service;

import com.mitocode.repo.Model.Especialidad;

import java.util.Optional;

public interface IEspecialidadService extends ICRUD<Especialidad> {

    Optional<Especialidad> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
