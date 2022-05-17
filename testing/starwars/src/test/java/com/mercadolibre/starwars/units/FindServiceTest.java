package com.mercadolibre.starwars.units;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    public void find(){
        //arrange
        List<CharacterDTO> expected = Utils.listasPorNombre();
        String name = "Darth";
        //act
        Mockito.when(repository.findAllByNameContains(name)).thenReturn(Utils.listasPorNombre());
        List<CharacterDTO> actual = service.find(name);
        //assert
        Assertions.assertEquals(expected,actual
                ,"Las listas de personajes no coinciden");
    }

}

