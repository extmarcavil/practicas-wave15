package com.bootcamp.moviesHQL.repository;

import com.bootcamp.moviesHQL.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
