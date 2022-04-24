package com.meli.starwars.services;

import com.meli.starwars.dto.CharacterDTO;
import com.meli.starwars.dto.CharacterResponseDTO;
import com.meli.starwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository repository;
    List<CharacterResponseDTO> listToShow = new ArrayList<>();
    public List<CharacterResponseDTO> getCharactersByName (String query) {
        List<CharacterDTO> listCharacters = repository.findAllByNameContains("nada");
        List<CharacterDTO> listFiltered = listCharacters.stream()
        .filter(person -> person.getName().contains(query))
                .collect(Collectors.toList());;

        for (Integer i = 0; i < listFiltered.size(); i++) {
            listToShow.add(new CharacterResponseDTO(listFiltered.get(i).getName(), listFiltered.get(i).getGender(), listFiltered.get(i).getHomeworld(), listFiltered.get(i).getSpecies(), listFiltered.get(i).getHeight(), listFiltered.get(i).getMass()));
        }

    return listToShow;
    }
}
