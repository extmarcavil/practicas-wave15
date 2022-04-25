package com.Spring.StarWars.repository;


import com.Spring.StarWars.dto.PersonajeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository{

    private final List<PersonajeDTO> listaFiltrada;

    public PersonajeRepository() {
        this.listaFiltrada = cargarLista();
    }


    @Override
    public List<PersonajeDTO> buscarFiltrado(String filtro) {
        return listaFiltrada.stream()
                .filter(p -> p.getName().contains(filtro))
                .collect(Collectors.toList());
    }

    private List<PersonajeDTO> cargarLista(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<>() {
        };
        List<PersonajeDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

}
