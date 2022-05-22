package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.repository;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

    @Query("select a from Actor a where a.favoriteMovie is not null")
    List<Actor> findAllByFavoriteMovieNotNull_Hql();

    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> findAllByRatingGreaterThan_Hql(@Param("rating") Integer rating);

    @Query("select a from Actor a join a.movies m where m.title = :movieName")
    List<Actor> findAllWhoWorkedInMovie(@Param("movieName") String movieName);

}
