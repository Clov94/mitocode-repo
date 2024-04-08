package com.mitocode.repo.consultorio.Repo;

import com.mitocode.repo.consultorio.Model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamenRepo extends JpaRepository<Examen, Integer> {
}
