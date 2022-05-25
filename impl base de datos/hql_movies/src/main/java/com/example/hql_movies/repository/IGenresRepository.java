package com.example.hql_movies.repository;

import com.example.hql_movies.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenresRepository extends JpaRepository<Genres, Long> {
}
