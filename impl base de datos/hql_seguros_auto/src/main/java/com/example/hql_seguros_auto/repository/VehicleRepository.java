package com.example.hql_seguros_auto.repository;

import com.example.hql_seguros_auto.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByOrderByFabricationYearAsc();

    List<Vehicle> findAllByWheelsGreaterThanEqualAndFabricationYearEquals(Integer wheels, Integer year);
}
