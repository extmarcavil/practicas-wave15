package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.mercadolibre.starwars.utils.CharacterFactory;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    void find(){

        List<CharacterDTO> list = CharacterFactory.getList();
        String query="darth";

        Mockito.when(repository.findAllByNameContains(query)).thenReturn(list);

        List<CharacterDTO> result = service.find(query);


        Assertions.assertAll(
                ()->Mockito.verify(repository,Mockito.times(1)).findAllByNameContains(query),
                ()-> Assertions.assertEquals(2,result.size()),
                ()->Assertions.assertTrue(
                        result.stream()
                                .allMatch(characterDTO -> characterDTO.getName().toLowerCase().contains(""))
                )
        );

    }


}
