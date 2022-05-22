package com.example.hql_seguros_auto.repository;

import com.example.hql_seguros_auto.entity.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinisterRepository extends JpaRepository<Sinister, Long> {
    List<Sinister> findAllByEconomicLossGreaterThanEqual(Double value);
}
