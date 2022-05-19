package com.bootcamp.hql.repository;


import com.bootcamp.hql.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actors, Integer> {

    @Query("FROM Actors WHERE favoriteMovieId IS NOT NULL")
    List<Actors> getAllActorsWithFavoriteMovie();

    @Query("FROM Actors WHERE rating > ?1")
    List<Actors> actorsByRating(BigDecimal rating);

    @Query("FROM Actors as a " +
            "JOIN ActorMovie as am on a.id = am.actorId " +
            "JOIN Movies as m on m.id = am.movieId and m.title = ?1")
    List<Actors> actorsByMovie(String movie);
}
