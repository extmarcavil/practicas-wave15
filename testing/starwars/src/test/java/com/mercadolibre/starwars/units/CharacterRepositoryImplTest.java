package com.mercadolibre.starwars.units;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryImplTest {

    CharacterRepository repository;

    @BeforeEach
    void setup(){repository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Prueba de encontrar por nombres Darth")
    public void findAllByNameContains(){
        //arrange
        List<CharacterDTO> expected = Utils.listasPorNombre();
        String name = "Darth";
        //act
        List<CharacterDTO> actual = repository.findAllByNameContains(name);
        //assert
        Assertions.assertEquals(expected,actual
                ,"No se encontro el personaje con nombre " + name);
    }
}
