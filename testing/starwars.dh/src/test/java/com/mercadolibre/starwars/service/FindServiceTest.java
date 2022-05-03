package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static fixture.CharacterFixture.aCharacterDTO;
import static fixture.CharacterFixture.otherCharacterDTO;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class FindServiceTest {

    private final static String QUERY = "luke";

    @Mock
    private CharacterRepositoryImpl repository;

    @InjectMocks
    private FindService findService;

    @Test
    void whenTheQueryMatchWithSomeCharacter_thenItsReturnedAsList() {
        List<CharacterDTO> characters = List.of(aCharacterDTO(), otherCharacterDTO());
        when(repository.findAllByNameContains(anyString())).thenReturn(characters);

        List<CharacterDTO> charactersExpected = findService.find(QUERY);

        assertThat(charactersExpected.size()).isEqualTo(characters.size());
        assertThat(charactersExpected).usingRecursiveComparison().isEqualTo(characters);

        verify(repository, atLeastOnce()).findAllByNameContains(QUERY);
    }

    @Test
    void whenTheQueryIsEmpty_thenAnEmptyListIsReturned() {
        when(repository.findAllByNameContains(anyString())).thenReturn(emptyList());

        assertThat(findService.find("").size()).isZero();
        verify(repository, atLeastOnce()).findAllByNameContains(any());
    }

}