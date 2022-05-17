package com.example.joyeria.repository;

import com.example.joyeria.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {

    List<Jewel> findAllByEnVentaIsTrue();

    Optional<Jewel> findByIdJewelAndEnVentaIsTrue(Long id);
}