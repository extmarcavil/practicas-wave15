package com.example.segurosautos.repository;

import com.example.segurosautos.dto.VehiculoPatenteYMarcaYModeloDTO;
import com.example.segurosautos.model.Siniestro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiniestroRepository extends CrudRepository<Siniestro, Integer> {

    @Query("SELECT sin FROM Siniestro sin WHERE sin.perdidaEconomica > :cost")
    List<Siniestro> findByCostGreaterThan(@Param("cost") Double cost );

    @Query("SELECT DISTINCT sum(sin.perdidaEconomica) FROM Siniestro sin JOIN sin.vehiculo v WHERE sin.perdidaEconomica > :cost")
    Double findBySiniestroCostGreaterThanAndTotalCost(@Param("cost") Double cost );
}
