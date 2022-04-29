package com.arqmulticapa.starwars.service;

import com.arqmulticapa.starwars.dto.PersonajeDTO;
import com.arqmulticapa.starwars.model.Personaje;
import com.arqmulticapa.starwars.repository.IPersonajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements IPersonajeService {

    private final IPersonajeRepository repository;

    @Override
    public List<PersonajeDTO> findByNameContains(String name) {
        List<Personaje> personajes=repository.findByNameContains(name);
        if (personajes == null) {
            throw new RuntimeException();
        }
        return personajes
                .stream()
                .map(personaje -> PersonajeDTO.builder()
                                            .name(personaje.getName())
                                            .birthYear(personaje.getBirth_year())
                                            .eyeColor(personaje.getEye_color())
                                            .hairColor(personaje.getHair_color())
                                            .skinColor(personaje.getSkin_color())
                                            .build())
                .collect(Collectors.toList());

    }
}
