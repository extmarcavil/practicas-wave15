package com.meli.relaciones.repository;

import com.meli.relaciones.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query("FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findActorsWithFavoriteMovie();

    @Query("FROM Actor a WHERE a.rating > :valor")
    List<Actor> findActorsWithFavoriteMovie(@Param("valor") Double valor);

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("FROM Actor a " +
            "JOIN a.actingMovies m " +
            "WHERE m.id = :movie")
    List<Actor> findActorsInMovie(@Param("movie") Long movie);
}
