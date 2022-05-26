package com.bootcamp.moviesHQL.service;


import com.bootcamp.moviesHQL.dto.RespActorDTO;
import com.bootcamp.moviesHQL.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorService {

    @Query("FROM Actor A WHERE A.favorite_movie_id IS NOT NULL")
    List<RespActorDTO> findAllActorsWithFavoriteMovie();

    @Query("FROM Actor A WHERE A.rating > :rating")
    List<Actor> findAllActorsByRating(@Param("rating") Double rating);

//    @Query("FROM Actor a JOIN a.actorMoviesById am WHERE am.title like :movieName")
//    agregar como entidad actormovie con onetomany y conectar de ahi
//    List<Actor> findAllActorsByMovie();
}
