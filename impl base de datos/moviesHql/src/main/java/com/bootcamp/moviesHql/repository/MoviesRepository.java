package com.bootcamp.moviesHql.repository;

import com.bootcamp.moviesHql.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository <Movies, Integer> {

    @Query("FROM Movies m JOIN m.actors a WHERE a.rating > :rating")
    List<Movies> findMoviesByActorsByRatingIsGreaterThan(@Param("rating") Double rating);
}
