package com.example.hql.repository;

import com.example.hql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public interface MovieRepository extends JpaRepository<Movie,Integer> {


    @Query("select m " +
            "from Movie m " +
            "left join fetch m.genre g")
    Stream<Movie> findAllMovies();

    @Query("select distinct m " +
            "from ActorMovie am " +
            "inner join am.movie m " +
            "inner join am.actor a " +
            "left join fetch m.genre g " +
            "where a.rating>:rating "
    )
    Stream<Movie> findByActorRatingGreaterThan(@Param("rating") BigDecimal rating);

    @Query("select m " +
            "from Movie m " +
            "inner join fetch m.genre g " +
            "where upper( g.name) = :genre")
    Stream<Movie> findByGenre(@Param("genre") String genre);

    @Query(value = "select distinct m " +
            "from ActorMovie am " +
            "inner join am.movie m " +
            "inner join am.actor a " +
            "left join fetch m.genre g " +
            "where a.rating>:rating and g.name=:genre ",
            countQuery = "select "
    )
    Stream<Movie> findByGenreAndActorRatingGreaterThan(@Param("genre") String genre,@Param("rating") BigDecimal rating);

}
