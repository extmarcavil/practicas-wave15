package com.example.hqlmoviesej1.repository;

import com.example.hqlmoviesej1.model.Actors;
import com.example.hqlmoviesej1.model.Movies;
import com.example.hqlmoviesej1.model.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends CrudRepository<Series, Integer> {

    @Query("SELECT DISTINCT ser FROM Series ser " +
            "WHERE ser.seasons.size > :amount")
    List<Series> findBySeasonsAmountGreaterThan(@Param(value = "amount") Integer amount);
}
