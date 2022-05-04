package com.mercadolibre.starwars.unitTesting;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {
    CharacterRepository repository;

    @BeforeEach
    void setup() {repository = new CharacterRepositoryImpl();}

    @Test
    @DisplayName(" Se encuentra un nombre que coincide ")
    public void getsOneResultFromSearchContains(){
        //arrange
        String query = "Luke";
        String charName = "Luke Skywalker";
        int expectedSize = 1;

        //act
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        //assert
        Assertions.assertEquals(expectedSize, result.size());
        Assertions.assertEquals(charName, result.get(0).getName());
    }

    @Test
    @DisplayName(" Se encuentran dos nombres que coinciden ")
    public void getsTwoResultsFromSearchContains(){
        //arrange
        String query = "Darth";
        String charName1 = "Darth Vader";
        String charName2 = "Darth Maul";
        int expectedSize = 2;

        //act
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        //assert
        Assertions.assertEquals(expectedSize, result.size());
        Assertions.assertEquals(charName1, result.get(0).getName());
        Assertions.assertEquals(charName2, result.get(1).getName());
    }

    @Test
    @DisplayName(" No se encuentran nombres que coincidan ")
    public void getsNoResultsFromSearchContains(){
        //arrange
        String query = "NOT_FOUND";
        int expectedSize = 0;

        //act
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        //assert
        Assertions.assertEquals(expectedSize, result.size());
    }
}
