package com.bootcamp.joyeria.repository;

import com.bootcamp.joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoyaRepository extends JpaRepository<Joya, Long> {
}