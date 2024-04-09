package com.mitocode.repo.Repo;

import com.mitocode.repo.Model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamenRepo extends JpaRepository<Examen, Integer> {
}
