package com.mitocode.repo.consultorio.Service.impl;

import com.mitocode.repo.consultorio.Model.Especialidad;
import com.mitocode.repo.consultorio.Model.Examen;
import com.mitocode.repo.consultorio.Repo.IEspecialidadRepo;
import com.mitocode.repo.consultorio.Repo.IExamenRepo;
import com.mitocode.repo.consultorio.Service.IEspecialidadService;
import com.mitocode.repo.consultorio.Service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements IExamenService {
    @Autowired
    private IExamenRepo repo;
    @Override
    public Examen save(Examen examen) {
        return repo.save(examen);
    }

    @Override
    public Examen update(Examen examen) {
        return repo.save(examen);
    }

    @Override
    public void deleteByUUID(String uuid) {
        repo.findAll().stream()
                .filter(paciente -> uuid.equals(paciente.getId_examen()))
                .findFirst().ifPresent(repo::delete);
    }

    @Override
    public Optional<Examen> findByUUID(String uuid) {
        return repo.findAll().stream()
                .filter(examen -> uuid.equals(examen.getId_examen()))
                .findFirst();
    }

    @Override
    public List<Examen> findAll() {
        return repo.findAll();
    }
}
