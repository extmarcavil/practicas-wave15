package com.example.starwars.unit.repository;

import com.example.starwars.exception.BadQueryException;
import com.example.starwars.model.Character;
import com.example.starwars.repository.IStarWarsRepository;
import com.example.starwars.repository.StarWarsRepository;
import com.example.starwars.utils.CharactersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StarWarsRepositoryTest {

    IStarWarsRepository repository;

    @BeforeEach
    void setup(){
        repository = new StarWarsRepository();
    }

    @Test
    @DisplayName("Find all characters that contains a certain name")
    public void findAllByNameContains(){
        // Arrange
        String query = "Darth";
        List<Character> expected = CharactersFactory.getListCharacters();

        // Act
        List<Character> result = repository.findAllByNameContains(query);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Find all characters that contains a any string")
    public void findAllByNameContainsAnyString(){
        // Arrange
        String query = "any string";
        List<Character> expected = new ArrayList<>();

        // Act
        List<Character> result = repository.findAllByNameContains(query);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Find all characters that contains a null name")
    public void findAllByNameContainsNull(){
        // Arrange
        String query = null;

        // Act and assert
        assertThrows(BadQueryException.class, () -> repository.findAllByNameContains(query));
    }
}
