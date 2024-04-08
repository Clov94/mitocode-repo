package com.mitocode.repo.consultorio.Repo;

import com.mitocode.repo.consultorio.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

}
