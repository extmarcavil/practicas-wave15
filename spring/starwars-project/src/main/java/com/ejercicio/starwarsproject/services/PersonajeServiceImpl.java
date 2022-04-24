package com.ejercicio.starwarsproject.services;

import com.ejercicio.starwarsproject.dto.PersonajeDTO;
import com.ejercicio.starwarsproject.models.Personaje;
import com.ejercicio.starwarsproject.repositories.PersonajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements PersonajeService {

    private final PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> findAllByNameContains(String query) {
        ModelMapper modelMapper = new ModelMapper();
        List<PersonajeDTO> personajeDTOS = new ArrayList<>();
        for(Personaje p: personajeRepository.findAllByNameContains(query)){

             PersonajeDTO personajeDTO = modelMapper.map( p, PersonajeDTO.class);
             personajeDTOS.add(personajeDTO);

        }
        return personajeDTOS;
    }
}
