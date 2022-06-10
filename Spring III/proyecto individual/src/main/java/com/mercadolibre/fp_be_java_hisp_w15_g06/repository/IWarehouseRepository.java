package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Agent;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {

    //1) Retornar el warehouse asociado al agent.
    Optional<Warehouse> findByIdAndAgent(Long id, Agent agent);
}
