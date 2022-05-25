package com.example.hql_movies.service;

import com.example.hql_movies.dto.ActorsDTO;
import com.example.hql_movies.dto.MoviesDTO;
import com.example.hql_movies.repository.IMoviesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService implements IMoviesService {
    private final IMoviesRepository moviesRepository;
    private final ModelMapper mapper;

    public MoviesService(IMoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
        this.mapper = new ModelMapper();
    }

    /**
     * Listar todos los actores que trabajan en la <película recibida por parámetro>
     *
     * @return List<MoviesDTO>
     **/
    @Override
    public List<ActorsDTO> getActorsByMovie(String movie) {
        return moviesRepository.findAllActorsOfAMovie(movie).stream()
                .map(v -> mapper.map(v, ActorsDTO.class)).collect(Collectors.toList());
    }

    /**
     * Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
     *
     * @return List<MoviesDTO>
     **/
    @Override
    public List<MoviesDTO> getMoviesOfActorsWithRatingGreaterThan(Double rating) {
        return moviesRepository.findAllMoviesWithActorsWithRatingGreaterThan(rating).stream()
                .map(v -> mapper.map(v, MoviesDTO.class)).collect(Collectors.toList());
    }

    /**
     * Listar todas las películas que pertenezcan al <género recibido por parámetro>
     *
     * @return List<MoviesDTO>
     **/
    @Override
    public List<MoviesDTO> getMoviesWithGenre(String genre) {
        return moviesRepository.findAllByGenresEquals(genre).stream()
                .map(v -> mapper.map(v, MoviesDTO.class)).collect(Collectors.toList());
    }
}
