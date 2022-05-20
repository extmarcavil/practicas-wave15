package com.bootcamp.consultashql.repository;

import com.bootcamp.consultashql.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre, Long> {
}
