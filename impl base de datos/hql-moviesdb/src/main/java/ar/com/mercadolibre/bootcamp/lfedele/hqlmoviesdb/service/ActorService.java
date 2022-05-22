package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.ActorDto;

import java.util.List;

public interface ActorService {
    List<ActorDto> findAll();
    List<ActorDto> findAllByFavoriteMovieNotNull_Hql();
    List<ActorDto> findAllByRatingGreaterThan_Hql(Integer rating);
    List<ActorDto> findAllWhoWorkedInMovie(String movieName);
}
