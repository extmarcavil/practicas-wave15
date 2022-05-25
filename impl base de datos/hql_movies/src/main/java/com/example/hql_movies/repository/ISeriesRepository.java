package com.example.hql_movies.repository;

import com.example.hql_movies.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository extends JpaRepository<Series, Long> {
    @Query("SELECT s " +
            "FROM Series s " +
            "WHERE s.seasons.size > :seasons")
    List<Series> findAllBySeasonsGreaterThan(Integer seasons);
}
