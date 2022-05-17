package com.joyeria.LasPerlas.repository;

import com.joyeria.LasPerlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iJoyaRepository extends JpaRepository<Joya,Long> {

}
