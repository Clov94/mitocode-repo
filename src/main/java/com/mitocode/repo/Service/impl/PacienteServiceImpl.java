package com.mitocode.repo.Service.impl;

import com.mitocode.repo.Model.Paciente;
import com.mitocode.repo.CommonLibrary.Exception.ModelException;
import com.mitocode.repo.Repo.IPacienteRepo;
import com.mitocode.repo.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {
    @Autowired
    private IPacienteRepo repo;

    @Override
    public Paciente save(Paciente paciente) {
//        if (!modelException.emailValidation(paciente.getEmail())) {
//            throw new ModelException("Email is not valid: " + paciente.getEmail());
//        }
        return repo.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        return repo.save(paciente);
    }

    @Override
    public void deleteByUUID(String uuid) {
        Optional<Paciente> paciente = repo.findAll().stream()
                .filter(p -> uuid.equals(p.getId_paciente()))
                .findFirst();
        if (paciente.isEmpty() || paciente.equals("")) {
            throw new ModelException("Paciente not found with UUID: " + uuid);
        } else {
            paciente.ifPresent(repo::delete);
        }
    }

    @Override
    public Optional<Paciente> findByUUID(String uuid) {
        Optional<Paciente> paciente =  repo.findAll().stream()
                .filter(p -> uuid.equals(p.getId_paciente()))
                .findFirst();
        if (paciente.isEmpty() || paciente.equals(null)) {
            throw new ModelException("Paciente not found with UUID: " + uuid);
        }
        return paciente;
    }

    @Override
    public List<Paciente> findAll() {
        return repo.findAll();
    }
}
