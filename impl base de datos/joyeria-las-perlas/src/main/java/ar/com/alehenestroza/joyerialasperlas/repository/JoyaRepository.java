package ar.com.alehenestroza.joyerialasperlas.repository;

import ar.com.alehenestroza.joyerialasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Long> {
}
