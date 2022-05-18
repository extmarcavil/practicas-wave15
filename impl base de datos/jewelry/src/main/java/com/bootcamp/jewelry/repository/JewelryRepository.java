package com.bootcamp.jewelry.repository;

import com.bootcamp.jewelry.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JewelryRepository extends JpaRepository<Jewel, Long> {

    List<Jewel> findAllByAvailableTrue();
}
