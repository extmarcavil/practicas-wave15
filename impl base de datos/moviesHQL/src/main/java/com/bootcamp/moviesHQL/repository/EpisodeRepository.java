package com.bootcamp.moviesHQL.repository;

import com.bootcamp.moviesHQL.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Long> {
}
