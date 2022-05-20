package com.example.segurosautos.repository;

import com.example.segurosautos.dto.VehiculoPatenteDTO;
import com.example.segurosautos.dto.VehiculoPatenteYMarcaDTO;
import com.example.segurosautos.model.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer> {

    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> findAllPatente();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioFabricacion ASC")
    List<Vehiculo> findAllVehiculoPatenteAndMarca();

    @Query("SELECT v FROM Vehiculo v WHERE v.cantRuedas > 4 AND v.anioFabricacion = :year")
    List<Vehiculo> findVehiculoPatenteByCantRuedasAndCurrentYear(@Param("year") Integer year);
}
