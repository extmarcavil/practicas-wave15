package com.joyeriaP.joyeriaP.repository;

import com.joyeriaP.joyeriaP.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewelry, Long> {


    List<Jewelry> findAllByIsSelledIsTrue();
}
