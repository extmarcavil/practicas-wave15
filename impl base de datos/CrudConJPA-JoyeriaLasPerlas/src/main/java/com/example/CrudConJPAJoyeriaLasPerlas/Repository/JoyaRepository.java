package com.example.CrudConJPAJoyeriaLasPerlas.Repository;

import com.example.CrudConJPAJoyeriaLasPerlas.Model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya,Integer> {
}
