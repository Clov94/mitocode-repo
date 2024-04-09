package com.mitocode.repo.Service.impl;

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
        repo.findAll().stream()
                .filter(paciente -> uuid.equals(paciente.getId_role()))
                .findFirst().ifPresent(repo::delete);
    }

    @Override
    public Optional<Especialidad> findByUUID(String uuid) {
        return repo.findAll().stream()
                .filter(paciente -> uuid.equals(paciente.getId_role()))
                .findFirst();
    }

    @Override
    public List<Especialidad> findAll() {
        return repo.findAll();
    }
}