package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season,Long> {
}
