package com.bootcamp.LasPerlas.repository;
import com.bootcamp.LasPerlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository <Joya, Long> {
}
