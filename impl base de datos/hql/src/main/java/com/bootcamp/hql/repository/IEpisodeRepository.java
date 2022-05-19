package com.bootcamp.hql.repository;

import com.bootcamp.hql.model.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episodes, Integer> {

    @Query("FROM Episodes as e JOIN ActorEpisode as ae on ae.episodeId = e.id " +
            "JOIN Actors as a on a.id = ae.actorId and a.firstName LIKE ?1")
    List<Episodes> episodesByActors(String actor);
}
