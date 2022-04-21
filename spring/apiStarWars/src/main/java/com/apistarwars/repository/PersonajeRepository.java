package com.apistarwars.repository;

import com.apistarwars.dto.PersonajeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements  IPersonajeRepository {

    //region Variables
    private List<PersonajeDTO> listPersonajes;
    //endregion

    //region Constructor

    public PersonajeRepository() {
        listPersonajes = loadPersonajesJSON();
    }

    //endregion

    //region Implementacion

    @Override
    public List<PersonajeDTO> buscarPersonaje(String nombre) {
       return listPersonajes.stream().filter(item -> item.getName()
                .toLowerCase(Locale.ROOT)
                .contains(nombre.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    //endregion

    //region Metodos Privados
    private List<PersonajeDTO> loadPersonajesJSON () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeRef      = new TypeReference<>() {
        };
        List<PersonajeDTO>                characters   = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
    //endregion
}
