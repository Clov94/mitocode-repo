package com.mitocode.repo.consultorio.Service;

import com.mitocode.repo.consultorio.Model.Examen;

import java.util.Optional;


public interface IExamenService extends ICRUD<Examen> {
    Optional<Examen> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
