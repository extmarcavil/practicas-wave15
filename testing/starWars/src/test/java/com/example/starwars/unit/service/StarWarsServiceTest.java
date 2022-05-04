package com.example.starwars.unit.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.exception.BadQueryException;
import com.example.starwars.model.Character;
import com.example.starwars.repository.IStarWarsRepository;
import com.example.starwars.service.StarWarsService;
import com.example.starwars.utils.CharactersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StarWarsServiceTest {

    @Mock
    IStarWarsRepository repository;

    @InjectMocks
    StarWarsService service;

    @Test
    @DisplayName("Find all characters that contains a certain name")
    public void findAllByNameContains(){
        // Arrange
        String query = "Darth";
        List<Character> charactersList = CharactersFactory.getListCharacters();
        List<CharacterDTO> expected = CharactersFactory.getListCharactersDTO();

        // Mock
        when(repository.findAllByNameContains(query)).thenReturn(charactersList);

        // Act
        List<CharacterDTO> result = service.findAllByNameContains(query);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Find all characters that contains a any string")
    public void findAllByNameContainsAnyString(){
        // Arrange
        String query = "any string";
        List<Character> charactersList = new ArrayList<>();
        List<CharacterDTO> expected = new ArrayList<>();

        // Mock
        when(repository.findAllByNameContains(query)).thenReturn(charactersList);

        // Act
        List<CharacterDTO> result = service.findAllByNameContains(query);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Find all characters that contains a null name")
    public void findAllByNameContainsNull(){
        // Arrange
        String query = null;

        // Mock
        when(repository.findAllByNameContains(query)).thenThrow(BadQueryException.class);

        // Act and Assert
        assertThrows(BadQueryException.class, () -> service.findAllByNameContains(query));
    }
}
