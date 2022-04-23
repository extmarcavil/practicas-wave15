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

@Repository
public class PersonajeRepositorioImpl implements PersonajeRepositorio {
    List<PersonajeDTO> listaPersonajes;

    public PersonajeRepositorioImpl(){
        listaPersonajes = initData();
        imprimir(listaPersonajes);
    }


    @Override
    public List<PersonajeDTO> getPersonajesPorNombre(String nombre) {
        List<PersonajeDTO> listaResultante = null;
        for(PersonajeDTO personajeDTO : listaPersonajes){
            if (personajeDTO.getName().contains(nombre)){
                listaPersonajes.add(personajeDTO);
            }
        }
        return listaResultante;
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
