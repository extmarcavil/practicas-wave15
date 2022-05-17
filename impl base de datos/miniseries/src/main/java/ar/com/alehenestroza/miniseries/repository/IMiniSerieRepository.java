package ar.com.alehenestroza.miniseries.repository;

import ar.com.alehenestroza.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
