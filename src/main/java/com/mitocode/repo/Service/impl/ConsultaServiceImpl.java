package com.mitocode.repo.Service.impl;

import com.mitocode.repo.DTO.ConsultaDto;
import com.mitocode.repo.Model.Consulta;
import com.mitocode.repo.Repo.IConsultaExamenRepo;
import com.mitocode.repo.Repo.IConsultaRepo;
import com.mitocode.repo.Service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ConsultaServiceImpl implements IConsultaService {
    @Autowired
    private IConsultaRepo repo;

    @Autowired
    private IConsultaExamenRepo consultaExamenRepo;

    @Override
    public Consulta save(Consulta consulta) {
        consulta.setFecha(LocalDateTime.now());
        consulta.getDetalleConsulta().stream().forEach(detalleConsulta -> detalleConsulta.setConsulta(consulta));
        return repo.save(consulta);
    }

    @Override
    public Consulta update(Consulta consulta) {
        return repo.save(consulta);
    }

    @Override
    public void deleteByUUID(String uuid) {
        repo.findAll().stream().filter(consulta -> uuid.equals(consulta.getIdConsulta())).findFirst().ifPresent(repo::delete);
    }

    /*@Override
    public ConsultaDto transactionalSave(Consulta consulta) {
        consulta.getDetalleConsulta().stream().forEach(detalleConsulta -> detalleConsulta.setConsulta(consulta));
        ConsultaDto consultaDto = new ConsultaDto();
        //consultaDto.setConsulta(consulta);
        consultaDto.getExamenes().stream().forEach(examen -> consultaExamenRepo.saveConsultaExamen(consultaDto.getIdConsulta(), examen.getId_examen()));
        return repo.save(consultaDto);
    }*/

    @Override
    public Optional<Consulta> findByUUID(String uuid) {
        return repo.findAll().stream().filter(consulta -> uuid.equals(consulta.getIdConsulta())).findFirst();
    }

    @Override
    public List<Consulta> findAll() {
        return repo.findAll();
    }
}
