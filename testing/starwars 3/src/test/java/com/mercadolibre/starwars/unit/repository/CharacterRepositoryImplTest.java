package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryImplTest {


    CharacterRepositoryImpl repository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains(){
        //arrange
        String query="darth";
        //act
        List<CharacterDTO> list = repository.findAllByNameContains(query);
        //assert
        assertAll(
                ()->assertEquals(2,list.size()),
                ()->assertTrue(list.stream().allMatch(characterDTO -> characterDTO.getName().toLowerCase().contains(query)))
        );

    }

    @Test
    void findAllByNameContainsCero(){
        //arrange
        String query="123";
        //act
        List<CharacterDTO> list = repository.findAllByNameContains(query);
        //assert
        assertAll(
                ()->assertNotNull(list),
                ()->assertEquals(0,list.size())
        );

    }
}
