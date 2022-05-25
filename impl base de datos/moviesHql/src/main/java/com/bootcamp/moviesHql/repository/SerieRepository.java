package com.bootcamp.moviesHql.repository;

import com.bootcamp.moviesHql.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {

    @Query("FROM Serie s WHERE s.seasonsById.size > :seasons")
    List<Serie> findAllWithMoreSeasonsThan(@Param("seasons") Integer seasons);

    List<Serie> findAll();

}
