package com.Spring.StarWars.service;

import com.Spring.StarWars.dto.PersonajeFiltradoDTO;
import com.Spring.StarWars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {

    IPersonajeRepository repository;

    public PersonajeService(IPersonajeRepository repository){
        this.repository = repository;
    }

    @Override
    public List<PersonajeFiltradoDTO> listarPersonajesFiltrados(String filtro) {
        List<PersonajeFiltradoDTO> filtrados = repository.buscarFiltrado(filtro)
                .stream()
                .map(f -> new PersonajeFiltradoDTO(f.getName(), f.getGender(), f.getHomeworld(), f.getSpecies(), f.getHeight(), f.getMass()))
                .collect(Collectors.toList());
        return filtrados;
    }
}
