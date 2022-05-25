package com.example.hql_movies.service;

import com.example.hql_movies.dto.ActorsDTO;
import com.example.hql_movies.model.Actors;
import com.example.hql_movies.repository.IActorsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorsService implements IActorsService {
    private final IActorsRepository actorsRepository;
    private final ModelMapper mapper;

    public ActorsService(IActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
        this.mapper = new ModelMapper();
    }

    /**
     * Listar todos los actores que tengan declarada una película favorita.
     *
     * @return List<ActorsDTO>
     **/
    @Override
    public List<ActorsDTO> getActorsWithFavoriteMovie() {
        List<Actors> actors = actorsRepository.findAllByFavoriteMovieIsNotNull();
        return actors.stream().map(v -> mapper.map(v, ActorsDTO.class)).collect(Collectors.toList());
    }

    /**
     * Listar todos los actores que tengan rating superior a <valor recibido por parámetro>.
     *
     * @return List<ActorsDTO>
     **/
    @Override
    public List<ActorsDTO> getActorsWithRatingGreaterThan(Double rating) {
        return actorsRepository.findAllByRatingGreaterThan(rating).stream()
                .map(v -> mapper.map(v, ActorsDTO.class)).collect(Collectors.toList());
    }
}
