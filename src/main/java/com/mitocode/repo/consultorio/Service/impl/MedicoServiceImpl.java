package com.mitocode.repo.consultorio.Service.impl;

import com.mitocode.repo.consultorio.Model.Medico;
import com.mitocode.repo.consultorio.Model.Paciente;
import com.mitocode.repo.consultorio.Repo.IMedicoRepo;
import com.mitocode.repo.consultorio.Repo.IPacienteRepo;
import com.mitocode.repo.consultorio.Service.IMedicoService;
import com.mitocode.repo.consultorio.Service.IPacienteService;
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
