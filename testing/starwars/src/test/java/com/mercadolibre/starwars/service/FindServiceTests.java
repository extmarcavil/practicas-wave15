package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class FindServiceTests {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Valida que se llame el método findAllByNameContains")
    public void find(){
        // arrange
        List<CharacterDTO> characterDTOS = new ArrayList<>();
        characterDTOS.add(new CharacterDTO());
        String query = "Luke";
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(characterDTOS);
        // act
        service.find(query);
        // assert
        Mockito.verify(characterRepository, atLeastOnce()).findAllByNameContains(query);
    }
}
