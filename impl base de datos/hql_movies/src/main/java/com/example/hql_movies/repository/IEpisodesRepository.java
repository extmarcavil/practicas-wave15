package com.example.hql_movies.repository;

import com.example.hql_movies.model.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodesRepository extends JpaRepository<Episodes, Long> {
    @Query("SELECT DISTINCT e " +
            "FROM Episodes e JOIN e.actors a" +
            " WHERE a.actors.firstName = :firstName AND a.actors.lastName = :lastName")
    List<Episodes> findAllEpisodesWithActor(String firstName, String lastName);
}
