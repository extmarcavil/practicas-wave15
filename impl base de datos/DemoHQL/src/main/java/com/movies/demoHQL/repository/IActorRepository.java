package com.movies.demoHQL.repository;

import com.movies.demoHQL.model.Actor;
import com.movies.demoHQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface sIActorRepository extends JpaRepository<Actor, Integer> {

    @Query("FROM Actor")
    List<Actor> findAllActors();

    @Query("From Actor A WHERE A.firstName LIKEr :name")
    Actor findByFirstName(@Param("name") String name);

   @Query("FROM Movie M  WHERE M.id = :id")
   Movie findMovieOfActor(@Param("id") Integer id);
}
