package com.example.ejerciciohqlmovies.repository;

import com.example.ejerciciohqlmovies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("FROM Actor a WHERE a.favoriteMovieId IS NOT NULL")
    List<Actor> findActorsWithFavoriteMovie();
}
