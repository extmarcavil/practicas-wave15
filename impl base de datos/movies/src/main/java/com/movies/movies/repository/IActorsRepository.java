package com.movies.movies.repository;

import com.movies.movies.model.Actor;
import com.movies.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IActorsRepository extends JpaRepository<Actor,Integer> {
    @Query("From Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findAllMoviesFav();
}
