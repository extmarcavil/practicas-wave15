package com.meli.relaciones.repository;

import com.meli.relaciones.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long> {
    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("FROM Movie m " +
            "JOIN m.workingActors a " +
            "WHERE a.rating > :rating")
    List<Movie> findMoviesWithActorByRating(@Param("rating") Double rating);

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
}
