package com.movies.movies.repository;


import com.movies.movies.dto.ActorDTO;
import com.movies.movies.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    @Query("SELECT a FROM Actor a WHERE a.favorite_movie_id IS NOT NULL")
    List<Actor> findActorByFavourite_movie();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorByRating(@Param("rating") double rating);

    @Query("SELECT a FROM Actor a JOIN a.actorMovies am WHERE am.title LIKE :title")
    List<Actor> findActorByTitle(@Param("title") String title);

    //FROM Actor a JOIN a.actorMoviesById am WHERE am.title like :movieName
}
