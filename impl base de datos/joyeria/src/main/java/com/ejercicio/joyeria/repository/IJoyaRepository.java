package com.ejercicio.joyeria.repository;
import com.ejercicio.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {

    List<Joya> findAllByAvailable();
}
