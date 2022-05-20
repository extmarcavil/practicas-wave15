package com.example.hql.repository;

import com.example.hql.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("select e " +
            "from ActorEpisode ae " +
            "inner join ae.actor a " +
            "inner join ae.episode e " +
            "inner join fetch e.season s " +
            "inner join fetch s.serie se " +
            "where a.firstName = :name"
    )
    Stream<Episode> findEpisodeByActorName(@Param("name") String name);
}