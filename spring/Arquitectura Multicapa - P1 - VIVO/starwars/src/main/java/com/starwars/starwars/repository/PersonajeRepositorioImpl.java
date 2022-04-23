package com.starwars.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.dto.PersonajeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositorioImpl implements PersonajeRepositorio {
    List<PersonajeDTO> listaPersonajes;

    public PersonajeRepositorioImpl(){
        listaPersonajes = initData();
        imprimir(listaPersonajes);
    }


    @Override
    public List<PersonajeDTO> getPersonajesPorNombre(String nombre) {
        return listaPersonajes.stream()
                              .filter(characterDTO -> contiene(nombre, characterDTO))
                              .collect(Collectors.toList());
    }

    private boolean contiene(String query, PersonajeDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }

    public List<PersonajeDTO> initData(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> tipoReferencia  = new TypeReference<>() {
        };
        List<PersonajeDTO> listaPersonajes   = null;
        try {
            listaPersonajes = objectMapper.readValue(file, tipoReferencia);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPersonajes;
    }

    public void imprimir(List<PersonajeDTO> listaPersonajes) {
        if (listaPersonajes.isEmpty()) {
            System.out.println("La Lista no esta cargada");
        }else{
            System.out.println("La Lista si esta cargada");
        }
    }
}
