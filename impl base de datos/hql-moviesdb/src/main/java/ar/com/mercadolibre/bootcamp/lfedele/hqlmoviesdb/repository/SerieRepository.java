package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.repository;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {

    @Query("select s from Serie s where s.seasons.size > :seasons")
    List<Serie> findAllWithMoreSeasonsThan(@Param("seasons") Integer seasons);

}
