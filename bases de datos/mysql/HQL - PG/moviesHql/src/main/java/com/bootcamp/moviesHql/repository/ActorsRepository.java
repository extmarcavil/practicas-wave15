package com.bootcamp.moviesHql.repository;

import com.bootcamp.moviesHql.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Integer>{

    @Query("FROM Actors a WHERE a.favorite_movie_id Is Not Null")
    List<Actors> getAllFavorite();

    @Query("FROM Actors a WHERE a.rating > :rating")
    List<Actors> getAllRating(@Param("rating") Double rating);

    @Query("select a FROM Actors a JOIN Actor_movie am ON a.id = am.actor_id WHERE am.movie_id = :id")
    List<Actors> getAllActorsMovie(@Param("id") Integer id);
}
