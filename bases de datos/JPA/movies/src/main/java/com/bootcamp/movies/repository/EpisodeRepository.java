package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Long> {

    @Query("FROM Episode e JOIN e.actors am WHERE am.id = :id")
    List<Episode> findEpisodeByIdActor(@Param("id") Long id);
}
