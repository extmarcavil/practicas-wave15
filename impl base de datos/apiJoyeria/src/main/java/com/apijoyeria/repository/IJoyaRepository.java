package com.apijoyeria.repository;
import com.apijoyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya,Integer> {
    List<Joya> findAllByVentaONoIsTrue();
}
