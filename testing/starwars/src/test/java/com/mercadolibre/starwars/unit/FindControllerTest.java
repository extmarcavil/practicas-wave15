package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void shouldFindCharactersByName() {

    // arrange
        String query = "Darth";

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        darthMaul.setGender("male");

        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setGender("male");
        List<CharacterDTO> expected = Arrays.asList(darthVader,darthMaul);

        Mockito.when(service.find(query)).thenReturn(expected);
    // act

        List<CharacterDTO> resultado = controller.find(query);

    // assert

        Assertions.assertEquals(resultado,expected);
        Mockito.verify(service,Mockito.atLeastOnce()).find(query);
    }

}
