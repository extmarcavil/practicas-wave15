package com.example.hql_movies.repository;

import com.example.hql_movies.model.Actors;
import com.example.hql_movies.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<Movies, Long> {
    @Query("SELECT a.actors " +
            "FROM Movies m JOIN m.actors a " +
            "WHERE m.title = :movie")
    List<Actors> findAllActorsOfAMovie(String movie);

    @Query("SELECT m " +
            "FROM Movies m JOIN m.actors a " +
            "WHERE a.actors.rating > :rating")
    List<Movies> findAllMoviesWithActorsWithRatingGreaterThan(Double rating);

    @Query("SELECT m " +
            "FROM Movies m " +
            "WHERE m.genres.name = :genre")
    List<Movies> findAllByGenresEquals(String genre);
}
