package com.mitocode.repo.Service;

import com.mitocode.repo.Model.Paciente;

import java.util.Optional;


public interface IPacienteService extends ICRUD<Paciente> {
    Optional<Paciente> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
