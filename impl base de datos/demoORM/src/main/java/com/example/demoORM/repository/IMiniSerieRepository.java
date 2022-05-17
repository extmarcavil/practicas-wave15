package com.example.demoORM.repository;

import com.example.demoORM.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {



}
