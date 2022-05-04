package com.mercadolibre.starwars.unitTesting;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.utils.CharacterFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Devuelve correctamente un nombre de la búsqueda")
    public void getsOneResultFromSearchContains(){
        //arrange
        //arrange
        String query = "Luke";

        CharacterFactory factory = new CharacterFactory();
        CharacterDTO luke = factory.getLuke();
        List<CharacterDTO> expected = List.of(luke);

        //MOCK
        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

        //act
        List<CharacterDTO> result = service.find(query);

        //assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Devuelve correctamente dos nombres de la búsqueda")
    public void getsTwoResultsFromSearchContains(){
        //arrange
        //arrange
        String query = "Darth";
        int expectedSize = 2;

        CharacterFactory factory = new CharacterFactory();
        CharacterDTO darthVader = factory.getDarthVader();
        String expectedName0 = "Darth Vader";
        CharacterDTO darthMaul = factory.getDarthMaul();
        String expectedName1 = "Darth Maul";
        List<CharacterDTO> expected = Arrays.asList(darthVader, darthMaul);

        //MOCK
        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

        //act
        List<CharacterDTO> result = service.find(query);

        //assert
        assertAll(
                () -> assertEquals(expectedSize, result.size()),
                () -> assertEquals(expectedName0, result.get(0).getName()),
                () -> assertEquals(expectedName1, result.get(1).getName())
        );
    }

    @Test
    @DisplayName("Devuelve correctamente ningún nombre de la búsqueda")
    public void getsNoResultsFromSearchContains(){
        //arrange
        //arrange
        String query = "NOT_FOUND";

        List<CharacterDTO> expected = List.of();

        //MOCK
        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

        //act
        List<CharacterDTO> result = service.find(query);

        //assert
        assertEquals(expected, result);
    }
}
