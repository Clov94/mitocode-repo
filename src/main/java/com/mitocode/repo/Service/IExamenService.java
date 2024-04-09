package com.mitocode.repo.Service;

import com.mitocode.repo.Model.Examen;

import java.util.Optional;


public interface IExamenService extends ICRUD<Examen> {
    Optional<Examen> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
