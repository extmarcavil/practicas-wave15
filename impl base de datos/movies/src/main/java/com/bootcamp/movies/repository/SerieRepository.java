package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SerieRepository extends JpaRepository<Serie,Long> {

    @Query("SELECT s FROM Serie s JOIN s.seasonsById ss GROUP BY ss.seriesBySerieId.id HAVING COUNT(ss.seriesBySerieId.id) > :amount")
    List<Serie> findSeriesByAmountSeasonsIsGreaterThan (@Param("amount") Long amount);
}
