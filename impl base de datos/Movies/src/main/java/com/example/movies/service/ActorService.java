package com.example.movies.service;

import com.example.movies.dto.response.ActorsResponseDTO;
import com.example.movies.model.ActorsEntity;
import com.example.movies.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActorService implements IActorService {

    private IActorRepository actorRepository;
    private ModelMapper modMap;

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
        modMap = new ModelMapper();
    }

    @Override
    public List<ActorsResponseDTO> findActorsWihtFavoriteMovie() {
        List<ActorsEntity> actors = actorRepository.findAllByFavoriteMovieIdIsNotNull();
        return mapToActorsDTO(actors);
    }

    private List<ActorsResponseDTO> mapToActorsDTO(List<ActorsEntity> actors) {
        List<ActorsResponseDTO> actorsDTO = actors.stream().map(a -> modMap.map(a, ActorsResponseDTO.class))
                                                           .collect(Collectors.toList());
        return actorsDTO;
    }
}
