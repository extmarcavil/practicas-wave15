package com.example.crudjoyeria.repository;

import com.example.crudjoyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyasRepository extends JpaRepository<Joya, Long> {
}
