package com.vparula.starwars.service;

import com.vparula.starwars.dto.PersonajeDTO;
import com.vparula.starwars.model.Personaje;
import com.vparula.starwars.repository.IRepositoryPersonaje;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePersonaje implements IServicePersonaje{
    private final IRepositoryPersonaje repo;
    private ModelMapper mapper;

    public ServicePersonaje ( IRepositoryPersonaje repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    public List<PersonajeDTO> devuelvoPersonaje(String nombre){
        List<Personaje> personajes = repo.getPersonajeByName(nombre);
        List<PersonajeDTO> personajeDto = new ArrayList<>();
        if(personajes.size()>0){
            personajeDto = personajes.stream().map(ing -> mapper.map(ing, PersonajeDTO.class)).collect(Collectors.toList());
        }
        return personajeDto;


    }
}
