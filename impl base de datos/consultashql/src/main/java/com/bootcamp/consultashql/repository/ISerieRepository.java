package com.bootcamp.consultashql.repository;

import com.bootcamp.consultashql.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT s FROM Serie s JOIN s.seasonsById se " +
            "GROUP BY se.seriesBySerieId.id HAVING COUNT(se.seriesBySerieId.id) > :amount")
    List<Serie> findSeriesByAmountSeasonsGreaterThan (@Param("amount") Long amount);
}
