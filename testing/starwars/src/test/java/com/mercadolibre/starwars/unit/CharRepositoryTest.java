package com.mercadolibre.starwars.unit;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class CharRepositoryTest {

    CharacterRepository charRepo;

    public CharRepositoryTest() {charRepo = new CharacterRepositoryImpl(); }

    @Test
    void findAllByNameContainsTest(){

        // arrange
        String query = "Darth";

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        darthMaul.setGender("male");

        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setGender("male");


        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setGender("male");

        List<CharacterDTO> expected = Arrays.asList(darthVader,darthMaul);

        // act

        List<CharacterDTO> result = charRepo.findAllByNameContains(query);

        // assert

        Assertions.assertEquals(expected,result);
    }

    @Test
    void findAllByNameContainsTestNullQuery(){

        // arrange
        String query = null;

        List<CharacterDTO> expected = null;

        // act - assert

        Assertions.assertThrows(NullPointerException.class,()-> charRepo.findAllByNameContains(query));
    }
}
