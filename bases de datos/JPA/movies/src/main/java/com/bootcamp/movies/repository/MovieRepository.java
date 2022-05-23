package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    //Se probo con inner join, pero ahi devuelve las peliculas para las que al menos 1 Actor tiene rating mayor.
    //La consulta era:
    //@Query("SELECT DISTINCT m From Movie m JOIN  m.actorsMovies am where am.rating>:rating")

    @Query("FROM Movie m WHERE not exists " +
            "(Select am.id from m.actorsMovies am where am.rating > :rating)")
    List<Movie> findMoviesByActorRating(@Param("rating") Double rating);

    @Query("FROM Movie m WHERE m.genre.id = :genre")
    List<Movie> findMoviesByGenre(@Param("genre") Long id);

}

