package com.example.ejerciciohqlmovies.service;

import com.example.ejerciciohqlmovies.dto.ActorDTO;
import com.example.ejerciciohqlmovies.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> findActorsWithFavouriteMovie() {
        ModelMapper mapper = new ModelMapper();
        var result = actorRepository.findActorsWithFavoriteMovie().stream()
                .map(actor -> mapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
        return result;
    }
}
