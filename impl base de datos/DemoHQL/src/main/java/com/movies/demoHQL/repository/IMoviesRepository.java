package com.movies.demoHQL.repository;

import com.movies.demoHQL.model.Movie;
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


}
