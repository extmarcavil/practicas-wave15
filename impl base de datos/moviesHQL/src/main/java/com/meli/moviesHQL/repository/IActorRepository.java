package com.meli.moviesHQL.repository;


import com.meli.moviesHQL.model.Actor;
import com.meli.moviesHQL.model.DTO.ActorDTO;
import com.meli.moviesHQL.model.Movie;
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
    List<Actor> findByFirstName(@Param("name") String name);

    @Query("FROM Actor A WHERE A.favoriteMovieId IS NOT NULL")
    List<Actor> getActorsWithFavoriteMovie();


    @Query("FROM Actor A WHERE A.rating > :rating")
    List<Actor> getActorsWithRatingMoreAs(@Param("rating") Double rating);


    @Query("FROM Actor A WHERE A.rating > :movie")
    List<Actor> getActorsThatWorkInMovie(@Param("movie") Integer movie);

    @Query("FROM Movie M  WHERE M.id = :id")
    Movie findMovieOfActor(@Param("id") Integer id);

}