package com.mitocode.repo.Repo;

import com.mitocode.repo.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

}
