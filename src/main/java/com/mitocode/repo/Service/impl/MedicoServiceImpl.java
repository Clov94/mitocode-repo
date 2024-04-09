package com.mitocode.repo.Service.impl;

import com.mitocode.repo.Model.Medico;
import com.mitocode.repo.Repo.IMedicoRepo;
import com.mitocode.repo.Service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements IMedicoService {
    @Autowired
    private IMedicoRepo repo;
    @Override
    public Medico save(Medico medico) {
        return repo.save(medico);
    }

    @Override
    public Medico update(Medico medico) {
        return repo.save(medico);
    }

    @Override
    public void deleteByUUID(String uuid) {
        repo.findAll().stream()
                .filter(medico -> uuid.equals(medico.getId_medico()))
                .findFirst().ifPresent(repo::delete);
    }

    @Override
    public Optional<Medico> findByUUID(String uuid) {
        return repo.findAll().stream()
                .filter(medico -> uuid.equals(medico.getId_medico()))
                .findFirst();
    }

    @Override
    public List<Medico> findAll() {
        return repo.findAll();
    }
}
