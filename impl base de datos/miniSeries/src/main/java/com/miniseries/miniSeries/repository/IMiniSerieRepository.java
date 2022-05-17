package com.miniseries.miniSeries.repository;

import com.miniseries.miniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
