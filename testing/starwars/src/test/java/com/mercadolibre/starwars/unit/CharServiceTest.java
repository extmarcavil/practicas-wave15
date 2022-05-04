package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
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
public class CharServiceTest {

    @Mock
    CharacterRepositoryImpl charRepo;

    @InjectMocks
    FindService service;

    @Test
    void findCharacterByNameTest(){
        String query = "Darth";

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        darthMaul.setGender("male");

        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setGender("male");
        List<CharacterDTO> expected = Arrays.asList(darthVader,darthMaul);

        Mockito.when(charRepo.findAllByNameContains(query)).thenReturn(expected);

        List<CharacterDTO> result = service.find(query);

        Assertions.assertEquals(result.size(), 2);
        Mockito.verify(charRepo,Mockito.atLeastOnce()).findAllByNameContains(query);
    }
}
