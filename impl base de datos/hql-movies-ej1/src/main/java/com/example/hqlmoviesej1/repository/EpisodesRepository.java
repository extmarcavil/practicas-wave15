package com.example.hqlmoviesej1.repository;

import com.example.hqlmoviesej1.model.Actors;
import com.example.hqlmoviesej1.model.Episodes;
import com.example.hqlmoviesej1.model.Movies;
import com.example.hqlmoviesej1.model.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodesRepository extends CrudRepository<Episodes, Integer> {

    @Query("SELECT DISTINCT ep FROM Episodes ep JOIN ep.actors act" +
            " WHERE act.actors.firstName = :firstName " +
            "   AND act.actors.lastName = :lastName")
    List<Episodes> findByActor(@Param(value = "firstName") String firstName, @Param(value = "lastName") String lastName);
}
