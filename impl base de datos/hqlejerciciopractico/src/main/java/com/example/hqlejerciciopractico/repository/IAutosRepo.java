package com.example.hqlejerciciopractico.repository;

import com.example.hqlejerciciopractico.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAutosRepo extends JpaRepository<Vehiculo,Long> {
    // test
    Optional<Vehiculo> findOneByPatente(String patente);

    List<Vehiculo> findAll();

    @Query("SELECT v from Vehiculo v order by v.dateMaking")
    List<Vehiculo> findAllOrderByMaking();
}
