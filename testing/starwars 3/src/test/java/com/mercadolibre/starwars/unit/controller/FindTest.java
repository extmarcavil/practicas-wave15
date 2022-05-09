package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.mercadolibre.starwars.utils.CharacterFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void findOk(){
        //arrange
        List<CharacterDTO> list= CharacterFactory.getList();
        when(service.find("Darth")).thenReturn(list);

        //act
        controller.find("Darth");

        //assert
        assertAll(
                ()->assertEquals("darth vader",list.get(0).getName()),
                ()->assertEquals(2,list.size()),
                ()->verify(service,times(1)).find("Darth")
        );


    }

}
