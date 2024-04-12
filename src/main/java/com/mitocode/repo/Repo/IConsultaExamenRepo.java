package com.mitocode.repo.Repo;

import com.mitocode.repo.Model.ConsultaExamen;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IConsultaExamenRepo extends JpaRepository<ConsultaExamen, Integer>{

    @Transactional
    @Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES(:idConsulta, :IdExamen)", nativeQuery = true)
    Integer saveConsultaExamen(@Param("idConsulta") String idConsulta, @Param("IdExamen") String idExamen);
}
