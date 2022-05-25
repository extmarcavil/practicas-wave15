package com.example.hql_movies.repository;

import com.example.hql_movies.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorsRepository extends JpaRepository<Actors, Long> {
    List<Actors> findAllByFavoriteMovieIsNotNull();

    List<Actors> findAllByRatingGreaterThan(Double rating);
}
