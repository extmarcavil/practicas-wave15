package com.example.EjercicioMiniSeries.repository;

import com.example.EjercicioMiniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
    
}
