package com.bootcamp.moviesHQL.repository;

import com.bootcamp.moviesHQL.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season,Long> {
}
