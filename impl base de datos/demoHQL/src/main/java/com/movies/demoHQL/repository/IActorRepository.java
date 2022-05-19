package com.movies.demoHQL.repository;

import com.movies.demoHQL.model.Actor;
import com.movies.demoHQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("FROM Actor")
    List<Actor> findAllActors();

    @Query("From Actor A WHERE A.firstName LIKE :name")
    Actor findByFirstName(@Param("name") String name);

   @Query("FROM Movie M  WHERE M.id = :id")
   Movie findMovieOfActor(@Param("id") Integer id);

    @Query("FROM Actor a WHERE a.favoriteMovieId IS NOT NULL")
    List<Actor> findAllActorsFavoriteMovie();

    @Query("FROM Actor a WHERE a.rating >:rating")
    List<Actor> findAllActorsByRating(Double rating);

    @Query("FROM Actor a JOIN a.actorMoviesById am WHERE am.title like :movieName")
    List<Actor> findActorsByMovieName(@Param("movieName") String name);
}
