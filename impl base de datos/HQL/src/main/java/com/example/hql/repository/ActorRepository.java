package com.example.hql.repository;

import com.example.hql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.stream.Stream;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    @Query("select a " +
            "from Actor a " +
            "inner join fetch a.favoriteMovie fm " +
            "left join fetch fm.genre g ")
    Stream<Actor> findByFavoriteMovieIsNotNull();

    @Query(
           "select a " +
           "from ActorMovie am " +
           "inner join am.actor a " +
           "left join fetch a.favoriteMovie fm " +
           "left join fetch fm.genre g " +
           "where am.movie.id = :id_movie"
    )
    Stream<Actor> findByMovieId(@Param("id_movie") Integer idMovie);

    @Query("select a " +
            "from Actor a " +
            "left join fetch a.favoriteMovie fm " +
            "left join fetch fm.genre g " +
            "where a.rating>:rating")
    Stream<Actor> findByRatingGreaterThan(@Param("rating") BigDecimal rating);

    @Query("select a " +
            "from Actor a " +
            "left join fetch a.favoriteMovie fm " +
            "left join fetch fm.genre g ")
    Stream<Actor> findAllActors();

    @Query(
            "select distinct a " +
            "from ActorMovie am " +
            "inner join am.actor a " +
            "left join fetch a.favoriteMovie fm " +
            "left join fetch fm.genre g " +
            "inner join am.movie m " +
            "where m.title like %:title%"
    )
    Stream<Actor> findByMovieTitle(@Param("title") String title);

    @Query(
            "select distinct a " +
            "from ActorMovie am " +
            "inner join am.actor a " +
            "left join fetch a.favoriteMovie fm " +
            "left join fetch fm.genre g " +
            "inner join am.movie m " +
            "where m.title like %:title% and a.rating>:rating"
    )
    Stream<Actor> findByMovieTitleAndRatingGreaterThan(@Param("title") String title, @Param("rating") BigDecimal rating);
}