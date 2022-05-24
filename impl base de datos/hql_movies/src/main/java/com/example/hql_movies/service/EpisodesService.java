package com.example.hql_movies.service;

import com.example.hql_movies.dto.EpisodesDTO;
import com.example.hql_movies.repository.IEpisodesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodesService implements IEpisodesService {
    private final IEpisodesRepository episodesRepository;
    private final ModelMapper mapper;

    public EpisodesService(IEpisodesRepository episodesRepository) {
        this.episodesRepository = episodesRepository;
        this.mapper = new ModelMapper();
    }

    /**
     * Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
     *
     * @return List<EpisodesDTO>
     **/
    @Override
    public List<EpisodesDTO> getEpisodesWithActor(String firstName, String lastName) {
        return episodesRepository.findAllEpisodesWithActor(firstName, lastName).stream()
                .map(v -> mapper.map(v, EpisodesDTO.class)).collect(Collectors.toList());
    }
}
