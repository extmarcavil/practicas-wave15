package com.bootcamp.moviesHql.repository;

import com.bootcamp.moviesHql.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("FROM Episode e LEFT JOIN e.actorEpisodesById a WHERE a.first_name = :firstName and a.last_name = :lastName")
    List<Episode> findAllWithActor(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
