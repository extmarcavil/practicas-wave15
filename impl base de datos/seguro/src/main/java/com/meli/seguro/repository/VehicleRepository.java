package com.meli.seguro.repository;

import com.meli.seguro.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("select v " +
            "from Vehicle v " +
            "inner join fetch v.accidents a"
    )
    List<Vehicle> findByAccidents();

    @Query("select v " +
            "from Vehicle v")
    List<Vehicle> findAllVehicle();

    @Query("select new Vehicle(v.patente) from Vehicle v ")
    List<Vehicle> findPatente();

    @Query("select new Vehicle(v.patente,v.marca) from Vehicle v ")
    List<Vehicle> findPatenteMarca();

    @Query("select new Vehicle(v.patente)" +
            " from Vehicle v" +
            " where v.cantRuedas>?1")
    List<Vehicle> findPatenteMasDe4Ruedas(Integer cant);

    @Query("select new Vehicle(v.patente)" +
            " from Vehicle v" +
            " where v.anioFabricacion=?1")
    List<Vehicle> findPatenteAnio(Integer year);

    @Query("select new Vehicle(v.patente)" +
            " from Vehicle v" +
            " where v.cantRuedas>?1 and v.anioFabricacion=?2")
    List<Vehicle> findPatenteByAnioAndCantRuedasGreaterThan(Integer cant, Integer year);

    @Query("select distinct new Vehicle(v.patente,v.marca,v.modelo)" +
            "from Vehicle v " +
            "inner join v.accidents a " +
            "where a.perdidaEconomica>?1 ")
    List<Vehicle> findByAccidentsPerdidaGreaterThan(BigDecimal perdida);

}