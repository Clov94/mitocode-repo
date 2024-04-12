package com.mitocode.repo.Service.impl;

import com.mitocode.repo.CommonLibrary.Exception.ModelException;
import com.mitocode.repo.Model.Especialidad;
import com.mitocode.repo.Repo.IEspecialidadRepo;
import com.mitocode.repo.Service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {
    @Autowired
    private IEspecialidadRepo repo;
    @Override
    public Especialidad save(Especialidad especialidad) {
        return repo.save(especialidad);
    }

    @Override
    public Especialidad update(Especialidad especialidad) {
        return repo.save(especialidad);
    }

    @Override
    public void deleteByUUID(String uuid) {
        Optional<Especialidad> especialidad = repo.findAll().stream().filter(paciente -> uuid.equals(paciente.getId_especialidad())).findFirst();

        if (especialidad.isEmpty() || especialidad.equals("")) {
            throw new ModelException("Especialidad not found with UUID: " + uuid);
        }
        especialidad.ifPresent(repo::delete);
    }

    @Override
    public Optional<Especialidad> findByUUID(String uuid) {
        Optional<Especialidad> especialidad = repo.findAll().stream()
                .filter(paciente -> uuid.equals(paciente.getId_especialidad()))
                .findFirst();
        if (especialidad.isEmpty() || especialidad.equals("")) {
            throw new ModelException("Especialidad not found with UUID: " + uuid);
        }
        return especialidad;
    }

    @Override
    public List<Especialidad> findAll() {
        return repo.findAll();
    }
}
