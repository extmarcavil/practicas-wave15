package com.bootcamp.moviesHQL.repository;

import com.bootcamp.moviesHQL.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SerieRepository extends JpaRepository<Serie,Long> {

}
