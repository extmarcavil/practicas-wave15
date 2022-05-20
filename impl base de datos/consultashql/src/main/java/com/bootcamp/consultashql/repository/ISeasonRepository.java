package com.bootcamp.consultashql.repository;

import com.bootcamp.consultashql.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeasonRepository extends JpaRepository<Season, Long> {
}
