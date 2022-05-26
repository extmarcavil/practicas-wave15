package com.meli.seguro.repository;

import com.meli.seguro.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("select v " +
            "from Vehicle v " +
            "inner join fetch v.accidents a"
    )
    List<Vehicle> findByAccidents();

    @Query("select v " +
            "from Vehicle v")
    List<Object[]> findAllVehicle();
}