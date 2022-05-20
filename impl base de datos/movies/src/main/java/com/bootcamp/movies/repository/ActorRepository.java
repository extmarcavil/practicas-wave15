package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("select A from Actor A where A.favoriteMovie is not null")
    List<Actor> findAllActorsByFavoriteMovieIsNotNull();
}