package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.incubator.vector.VectorOperators;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository implements IStarWarsRepository{
    List<PersonajeDTO> listCharacters;

    public StarWarsRepository(){
        init();
    }

    private void init(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<>() {};
        try {
            listCharacters = objectMapper.readValue(file, typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<PersonajeDTO> getCharacterByName(String name){
        List<PersonajeDTO> filterPersonajes = listCharacters.stream().filter(p -> p.getName().toUpperCase().contains(name)).collect(Collectors.toList());
        return filterPersonajes;
    }
}
