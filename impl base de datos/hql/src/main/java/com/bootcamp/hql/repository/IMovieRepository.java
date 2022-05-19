package com.bootcamp.hql.repository;

import com.bootcamp.hql.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movies, Integer> {

    @Query("FROM Movies as m " +
            "JOIN ActorMovie as am on m.id = am.movieId " +
            "JOIN Actors as a on a.id = am.actorId and a.rating > ?1")
    List<Movies> moviesByActorsRating(BigDecimal rating);

    @Query("FROM Movies as m " +
            "JOIN Genres as g on m.genresByGenreId.name = ?1")
    List<Movies> moviesByGenre(String genre);
}
