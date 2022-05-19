package com.bootcamp.hql.repository;

import com.bootcamp.hql.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Series, Integer> {

    @Query("SELECT se FROM Series as se JOIN Seasons as s on se.id = s.serieId and s.number > ?1 group by se.id")
    List<Series> seriesBySeasons(Integer seasons);
}
