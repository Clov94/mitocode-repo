package com.mitocode.repo.consultorio.Service;

import com.mitocode.repo.consultorio.Model.Paciente;

import java.util.Optional;


public interface IPacienteService extends ICRUD<Paciente> {
    Optional<Paciente> findByUUID(String uuid);

    void deleteByUUID(String uuid);

}
