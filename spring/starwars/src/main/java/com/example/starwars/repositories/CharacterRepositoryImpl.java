package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {

    private final List<CharacterDTO> database;

    public CharacterRepositoryImpl () {
        this.database = loadDataBase();
    }

    @Override
    public List<CharacterDTO> findAllByNameContains ( String query ) {
        return database.stream().filter(characterDTO -> characterDTO.getName().contains(query)).collect(Collectors.toList());
//        List<CharacterDTO> listaNombre = new ArrayList<>();
//        for (CharacterDTO c: database) {
//            String [] nombre = c.getName().split(" ");
//            for (String s: nombre) {
//                if(s.equals(query)){
//                    listaNombre.add(c);
//                    break;
//                }
//            }
//        }
//        return listaNombre;
    }

    private List<CharacterDTO> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper                      objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef      = new TypeReference<>() {
        };
        List<CharacterDTO>                characters   = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public List<CharacterDTO> getDatabase() {
        return database;
    }
}
