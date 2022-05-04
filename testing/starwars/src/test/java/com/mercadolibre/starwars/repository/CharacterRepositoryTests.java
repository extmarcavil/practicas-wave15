package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTests {

    static CharacterRepository characterRepository;

    @BeforeAll
    private static void setUp(){
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Encontrar todos los personajes que coincidan con una query")
    public void findAllCharacters(){
        // arrange
        String query = "Luke";
        List<CharacterDTO> characterDTOS;

        // act
        characterDTOS = characterRepository.findAllByNameContains(query);

        // assert
        Assertions.assertEquals(Integer.valueOf(characterDTOS.size()),Integer.valueOf(1));
    }

    @Test
    @DisplayName("No encuentra ningún elemento en la lista")
    public void notFindCharacters(){
        // arrange
        String query = "NOT FOUND";
        List<CharacterDTO> characterDTOS;

        // act
        characterDTOS = characterRepository.findAllByNameContains(query);

        // assert
        Assertions.assertTrue(characterDTOS.isEmpty());
    }

    @Test
    @DisplayName("Retorna NullPointer")
    public void findNullCharacters(){
        // arrange
        String query = null;
        List<CharacterDTO> characterDTOS;

        // act & assert
        Assertions.assertThrows(NullPointerException.class, ()->characterRepository.findAllByNameContains(query));
    }

}
