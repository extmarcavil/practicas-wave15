package com.bootcamp.consultashql.repository;

import com.bootcamp.consultashql.model.Actor;
import com.bootcamp.consultashql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("FROM Actor")
    List<Actor> findAllActors();

    @Query("FROM Actor a WHERE a.favoriteMovieId is not null")
    List<Actor> findActorsWithFavoriteMovie();

    @Query("From Actor a WHERE a.firstName LIKE :name")
    Actor findByFirstName(@Param("name") String name);

   @Query("FROM Movie m WHERE m.id = :id")
   Movie findMovieOfActor(@Param("id") Integer id);

   @Query("FROM Actor a JOIN a.actorMoviesById am WHERE am.title like :movieName")
   List<Actor> findActorsOfMovie(@Param("movieName") String movie);

   @Query("FROM Actor a WHERE a.rating > :rating")
   List<Actor> findActorsWithRatingGreaterThan(@Param("rating") Double rating);
}
