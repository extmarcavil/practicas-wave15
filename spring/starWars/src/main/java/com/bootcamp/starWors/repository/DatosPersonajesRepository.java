package com.bootcamp.starWors.repository;

import com.bootcamp.starWors.dtos.PersonajeSWDTO;
import com.bootcamp.starWors.models.PersonajeSW;
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
public class DatosPersonajesRepository implements IDatosPersonajesRepository {

    private final List<PersonajeSW> datosGuardados;

   public DatosPersonajesRepository() {
       this.datosGuardados = loadData();
    }


    private List<PersonajeSW> loadData(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeSW>> typeRef = new TypeReference<>() {};
        List<PersonajeSW> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

    @Override
    public List<PersonajeSW> findAllByNameContains(String name) {
        return datosGuardados.stream().filter(i->i.getName().contains(name)).collect(Collectors.toList());

    }

}
