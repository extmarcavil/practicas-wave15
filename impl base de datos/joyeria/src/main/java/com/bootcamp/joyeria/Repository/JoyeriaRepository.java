package com.bootcamp.joyeria.Repository;

import com.bootcamp.joyeria.Model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyeriaRepository extends JpaRepository<Joya, Long> {

}
