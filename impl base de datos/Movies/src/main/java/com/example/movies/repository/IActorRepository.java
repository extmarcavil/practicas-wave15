package com.example.movies.repository;

import com.example.movies.dto.response.ActorsResponseDTO;
import com.example.movies.model.ActorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<ActorsEntity, Long> {
    List<ActorsEntity> findAllByFavoriteMovieIdIsNotNull();
}
