package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ServiceUnitTests {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findNameContainingX() {
        // arrange
        List<CharacterDTO> resultCharacter = List.of(new CharacterDTO());
        Mockito.when(characterRepository.findAllByNameContains("darth")).thenReturn(resultCharacter);

        // act
        List<CharacterDTO> lst = findService.find("darth");

        // assert
        Assertions.assertEquals(lst, resultCharacter);
    }
}
