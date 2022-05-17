package com.bootcamp.joyeriaLasPerlas.repository;

import com.bootcamp.joyeriaLasPerlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
}
