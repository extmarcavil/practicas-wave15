package com.spring.ejercicioclavescompuestas.repository;

import com.spring.ejercicioclavescompuestas.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}
