package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository repo;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Busqueda con parametro correcto retorna lo esperado")
    void findTest() {
        //arrange
        CharacterDTO luke = newCharacter("Luke Skywalker", 77);
        CharacterDTO lukeM = newCharacter("Luke Moonwalker", 7);
        List<CharacterDTO> expected = Arrays.asList(luke, lukeM);
        //Mocks
        Mockito.when(repo.findAllByNameContains("Luke")).thenReturn(expected);
        //act
        List<CharacterDTO> actual = service.find("Luke");
        //assert
        Assertions.assertEquals(expected, actual);
    }

    private CharacterDTO newCharacter(String name, int mass) {
        CharacterDTO character = new CharacterDTO();

        character.setName(name);
        character.setHeight(172);
        character.setMass(mass);
        character.setHair_color("blond");
        character.setSkin_color("fair");
        character.setEye_color("blue");
        character.setBirth_year("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");

        return character;
    }
}
