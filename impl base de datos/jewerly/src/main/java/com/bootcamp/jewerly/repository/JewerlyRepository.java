package com.bootcamp.jewerly.repository;

import com.bootcamp.jewerly.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewerlyRepository extends JpaRepository<Jewel, Long> {
}
