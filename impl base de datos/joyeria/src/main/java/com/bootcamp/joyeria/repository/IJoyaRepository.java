package com.bootcamp.joyeria.repository;

import com.bootcamp.joyeria.model.Joya;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
}
