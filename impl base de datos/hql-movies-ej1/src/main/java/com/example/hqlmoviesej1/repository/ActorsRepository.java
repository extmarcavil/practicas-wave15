package com.example.hqlmoviesej1.repository;

import com.example.hqlmoviesej1.model.Actors;
import com.example.hqlmoviesej1.model.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorsRepository extends CrudRepository<Actors, Integer> {

    List<Actors> findDistinctByMoviesIsNotNull();

    List<Actors> findDistinctByRatingGreaterThan(@Param(value = "rating") Double rating);

    @Query("SELECT DISTINCT a FROM Actors a JOIN a.movies mov " +
            "WHERE mov.movies.title = :movie")
    List<Actors> findByMovies(@Param(value = "movie") String movie);

}
