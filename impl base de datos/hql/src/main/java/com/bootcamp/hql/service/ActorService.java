package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.ActorDto;
import com.bootcamp.hql.model.Actors;
import com.bootcamp.hql.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService implements IActorService {

    private final IActorRepository actorRepository;
    private final ModelMapper mapper;

    public ActorService(IActorRepository actorRepository){
        this.actorRepository = actorRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<ActorDto> getAll() {
        List<Actors> actors = actorRepository.findAll();
        List<ActorDto> actorsDto = new ArrayList<>();
        for (Actors actor : actors) {
            actorsDto.add(mapper.map(actor, ActorDto.class));
        }
        return actorsDto;
    }

    @Override
    public List<ActorDto> getAllActorsWithFavoriteMovie() {
        List<Actors> actors = actorRepository.getAllActorsWithFavoriteMovie();
        List<ActorDto> actorsDto = new ArrayList<>();
        for (Actors actor : actors) {
            actorsDto.add(mapper.map(actor, ActorDto.class));
        }
        return actorsDto;
    }

    @Override
    public List<ActorDto> actorsByRating(BigDecimal rating) {
        List<Actors> actors = actorRepository.actorsByRating(rating);
        List<ActorDto> actorsDto = new ArrayList<>();
        for (Actors actor : actors) {
            actorsDto.add(mapper.map(actor, ActorDto.class));
        }
        return actorsDto;
    }

    @Override
    public List<ActorDto> actorsByMovie(String movie) {
        List<Actors> actors = actorRepository.actorsByMovie(movie);
        List<ActorDto> actorsDto = new ArrayList<>();
        for (Actors actor : actors) {
            actorsDto.add(mapper.map(actor, ActorDto.class));
        }
        return actorsDto;
    }
}
