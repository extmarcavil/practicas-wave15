package com.example.hql.service;

import com.example.hql.api.dto.ActorDto;
import com.example.hql.api.mapper.ActorMapper;
import com.example.hql.entity.Actor;
import com.example.hql.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository repository;
    private final ActorMapper mapper;

    @Transactional(readOnly = true)
    public List<ActorDto> getActorsWithFavoriteMovies(){
        return repository.findByFavoriteMovieIsNotNull()
                .map(actor -> mapper.actorToActorDto(actor))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ActorDto> getActorsInMovie(Integer idMovie){
        return repository.findByMovieId(idMovie)
                .map(actor -> mapper.actorToActorDto(actor))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ActorDto> getActors(BigDecimal rating,String title){
        Stream<Actor> stream;
        if (rating == null && title == null) {
            stream=repository.findAllActors();
        }
        else {
            if (title == null) stream = repository.findByRatingGreaterThan(rating);
            else if (rating == null ) stream= repository.findByMovieTitle(title);
            else stream = repository.findByMovieTitleAndRatingGreaterThan(title,rating);
        }
        return stream
                .map(actor -> mapper.actorToActorDto(actor))
                .collect(Collectors.toList());
    }



}
