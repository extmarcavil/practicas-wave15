package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.impl;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.EpisodeDto;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.repository.EpisodeRepository;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.EpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    private final EpisodeRepository repo;
    private final ModelMapper mapper;

    public EpisodeServiceImpl(EpisodeRepository repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<EpisodeDto> findAllWithActor(String firstName, String lastName) {
        return this.repo
                .findAllWithActor(firstName,lastName)
                .stream()
                .map(e -> mapper.map(e,EpisodeDto.class))
                .collect(Collectors.toList());
    }
}
