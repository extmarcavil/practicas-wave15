package com.vparula.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vparula.starwars.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositoryPersonaje implements IRepositoryPersonaje {
    List<Personaje> personajes;


    public RepositoryPersonaje(){

            personajes = loadDataBase();
    }
    private List<Personaje> loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

    @Override
    public List<Personaje> getPersonajeByName(String name) {
        return personajes.stream().filter(i->i.getName().contains(name)).collect(Collectors.toList());

    }

}
