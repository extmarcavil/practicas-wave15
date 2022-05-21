package com.bootcamp.CompanyCarHQL.repository;

import com.bootcamp.CompanyCarHQL.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> findAllPatente();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.year_of_production")
    List<Vehiculo> findPatenteAndMarcaSortByYear();

    @Query("SELECT v FROM Vehiculo v WHERE v.amount_of_wheels > 4 AND v.year_of_production = :year")
    List<Vehiculo> findPatenteWhereWheelsGreaterThat(@Param("year") Integer year);
}
