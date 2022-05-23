package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SerieRepository extends JpaRepository<Serie,Long> {

    @Query("Select distinct s FROM Serie s Join s.seasons ss where ss.number>:count")
    List<Serie> findSerieBySeasonCount(Integer count);

}
