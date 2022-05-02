package com.bootcamp.starWors.services;

import com.bootcamp.starWors.dtos.PersonajeSWDTO;
import com.bootcamp.starWors.models.PersonajeSW;
import com.bootcamp.starWors.repository.DatosPersonajesRepository;
import com.bootcamp.starWors.repository.IDatosPersonajesRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatosPersonajesService {

    private final IDatosPersonajesRepository icharacterRepository;
    private ModelMapper mapper;

    public DatosPersonajesService(DatosPersonajesRepository characterRepository) {
        this.icharacterRepository = characterRepository;
        this.mapper = new ModelMapper();
    }

    public List<PersonajeSWDTO> findCharacter(String namePersonaje) {
        List<PersonajeSW> personajes = icharacterRepository.findAllByNameContains(namePersonaje);
        List<PersonajeSWDTO> personajeDto = new ArrayList<>();
        if(personajes.size()>0){
            personajeDto = personajes.stream().map(p -> mapper.map(p, PersonajeSWDTO.class)).collect(Collectors.toList());
        }
        return personajeDto;
    }
}
