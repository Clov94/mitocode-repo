package com.mitocode.repo.Service.impl;

import com.mitocode.repo.Repo.IExamenRepo;
import com.mitocode.repo.Model.Examen;
import com.mitocode.repo.Service.IExamenService;
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
