package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.CharacterUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CharacterRepositoryImplTest {

    private static CharacterRepository characterRepository;

    @BeforeAll
    static void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContainsAtLeastOne(){
        //arrange
        String query = "Darth";

        //act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        //assert
        assertEquals(result.size(), CharacterUtil.getListDart().size());
        for(int i = 0; i < result.size(); i++){
            assertTrue(result.contains(CharacterUtil.getListDart().get(i)));
        }
    }

    @Test
    void findAllByNameContainsAnyone(){
        //arrange
        String query = "qweqwe";

        //act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        //assert
        assertTrue(result.isEmpty());

    }
}
