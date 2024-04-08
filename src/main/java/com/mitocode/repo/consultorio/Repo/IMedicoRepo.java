package com.mitocode.repo.consultorio.Repo;

import com.mitocode.repo.consultorio.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMedicoRepo extends JpaRepository<Medico, Integer> {

}
