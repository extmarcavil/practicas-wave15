package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.impl;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.ActorDto;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model.Actor;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.repository.ActorRepository;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.ActorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    private final ModelMapper mapper;

    public ActorServiceImpl(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<ActorDto> findAll() {
        return mapResult(actorRepository.findAll());
    }

    @Override
    public List<ActorDto> findAllByFavoriteMovieNotNull_Hql() {
        return mapResult(actorRepository.findAllByFavoriteMovieNotNull_Hql());
    }

    @Override
    public List<ActorDto> findAllByRatingGreaterThan_Hql(Integer rating) {
        return mapResult(actorRepository.findAllByRatingGreaterThan_Hql(rating));
    }

    @Override
    public List<ActorDto> findAllWhoWorkedInMovie(String movieName) {
        return mapResult(actorRepository.findAllWhoWorkedInMovie(movieName));
    }

    private List<ActorDto> mapResult(Iterable<Actor> it) {
        return StreamSupport
                .stream(it.spliterator(), false)
                .map(a -> mapper.map(a, ActorDto.class))
                .collect(Collectors.toList());
    }
}
