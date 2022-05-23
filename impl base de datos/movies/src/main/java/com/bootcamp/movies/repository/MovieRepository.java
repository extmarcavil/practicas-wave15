package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("FROM Movie m JOIN m.actorMoviesById am WHERE am.rating > :rating")
    List<Movie> findMoviesByActorsByRatingIsGreaterThan(@Param("rating") Double rating);

    @Query("FROM Movie m WHERE m.genresByGenreId.name like :genre")
    List<Movie> findMoviesByGenreName(@Param("genre") String genre);
}
