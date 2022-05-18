package com.lasperlas.Las.Perlas.repository;

import com.lasperlas.Las.Perlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
}
