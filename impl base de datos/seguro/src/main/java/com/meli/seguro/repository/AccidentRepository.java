package com.meli.seguro.repository;

import com.meli.seguro.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}