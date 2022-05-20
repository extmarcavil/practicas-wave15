package com.bootcamp.consultashql.repository;

import com.bootcamp.consultashql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<Movie, Integer> {

    @Query("FROM Movie m order by m.title")
    List<Movie> findAllMovies();

    @Query("FROM Movie m WHERE m.title LIKE %:title%")
    List<Movie> findMoviesByTitleLike(@Param("title") String title);

    @Query("FROM Movie m JOIN m.actorMoviesById am WHERE am.rating > :rating")
    List<Movie> findMoviesByActorsWithRatingIsGreaterThan(@Param("rating") Double rating);

    @Query("FROM Movie m WHERE m.genresByGenreId.name like :genre")
    List<Movie> findMoviesByGenre(@Param("genre") String genre);

}
