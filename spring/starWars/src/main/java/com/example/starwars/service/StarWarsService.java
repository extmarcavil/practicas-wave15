package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repository.IStarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService implements IStarWarsService {

    private IStarWarsRepository repository;

    public StarWarsService(IStarWarsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CharacterDTO> findAllByNameContains(String query) {
        // Crear el dto con los datos requeridos.
        return repository.findAllByNameContains(query).stream()
                .map(v -> new CharacterDTO(v.getName(), v.getGender(), v.getHomeworld(), v.getSpecies(),
                        v.getHeight(), v.getMass()))
                .collect(Collectors.toList());
    }
}
