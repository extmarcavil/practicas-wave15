package com.ejercicio.starwarsproject.repositories;

import com.ejercicio.starwarsproject.dto.PersonajeDTO;
import com.ejercicio.starwarsproject.models.Personaje;
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
public class PersonajeRepositoryImpl  implements  PersonajeRepository{

    private final List<Personaje> database;

    public PersonajeRepositoryImpl () {
        this.database = loadDataBase();
    }
    @Override
    public List<Personaje> findAllByNameContains(String query) {
        return database.stream()
                .filter(personajeDTO -> matchWith(query, personajeDTO))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, Personaje personaje) {
        return  personaje.getName().toUpperCase().contains(query.toUpperCase());
    }

    private List<Personaje> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef      = new TypeReference<>() {
        };
        List<Personaje> personajeList   = null;
        try {
            personajeList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajeList;
    }
}
