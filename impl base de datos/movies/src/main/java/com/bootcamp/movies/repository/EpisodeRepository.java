package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Long> {
    @Query("FROM Episode e JOIN e.actorEpisodesById ea WHERE ea.firstName like :firstName AND ea.lastName like :lastName")
    List<Episode> findEpisodesByActorByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
