package com.mitocode.repo.consultorio.Service;

import com.mitocode.repo.consultorio.Model.Especialidad;

import java.util.Optional;

public interface IEspecialidadService extends ICRUD<Especialidad> {

    Optional<Especialidad> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
