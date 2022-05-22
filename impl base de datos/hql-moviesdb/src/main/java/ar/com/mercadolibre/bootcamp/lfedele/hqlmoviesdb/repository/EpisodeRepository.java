package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.repository;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends CrudRepository<Episode,Long> {

    @Query("from Episode e left join e.actors a where a.firstName = :firstName and a.lastName = :lastName")
    List<Episode> findAllWithActor(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
