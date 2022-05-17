package com.joyas.ejerciciojoyas.repository;

import com.joyas.ejerciciojoyas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya,Long> {
}
