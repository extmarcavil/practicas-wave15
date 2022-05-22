package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.repository;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {

    @Query("select distinct m from Movie m join m.actors a where a.rating > :rating")
    List<Movie> findAllWithActorsRatingGreaterThan(@Param("rating") Integer rating);

    @Query("select m from Movie m join m.genre g where g.name = :genreName")
    List<Movie> findAllWithGenre(@Param("genreName") String genreName);
    
}
