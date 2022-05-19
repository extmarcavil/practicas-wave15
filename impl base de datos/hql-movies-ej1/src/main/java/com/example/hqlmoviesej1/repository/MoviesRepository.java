package com.example.hqlmoviesej1.repository;

import com.example.hqlmoviesej1.model.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {

    @Query("SELECT DISTINCT mov FROM Movies mov JOIN mov.actors actRel " +
            "WHERE actRel.actors.rating > :rating")
    List<Movies> findByActorsRatingGreatherThan(@Param(value = "rating") Double rating);

    @Query("SELECT DISTINCT mov FROM Movies mov " +
            "WHERE mov.genres.name = :genre")
    List<Movies> findByGenres(@Param(value = "genre") String genre);

}
