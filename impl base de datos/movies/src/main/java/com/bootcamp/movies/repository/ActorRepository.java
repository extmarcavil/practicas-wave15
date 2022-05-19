package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findAllByMoviesByFavoriteMovieIdIsNotNull();
    List<Actor> findActorsByRatingIsGreaterThan(Double rating);
}
