package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.CharacterUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;


    @Test
    void findAllByNameContainsAtLeastOne(){
        //arrange
        String query = "Darth";
        Mockito.when(findService.find(any(String.class))).thenReturn(CharacterUtil.getListDart());

        //act
        List<CharacterDTO> result = findController.find(query);

        //assert
        assertEquals(result.size(), CharacterUtil.getListDart().size());
        for(int i = 0; i < result.size(); i++){
            assertTrue(result.contains(CharacterUtil.getListDart().get(i)));
        }
        verify(findService, times(1)).find(any(String.class));
    }

    @Test
    void findAllByNameContainsAnyone(){
        //arrange
        String query = "qweqwe";
        Mockito.when(findService.find(any(String.class))).thenReturn(new ArrayList<>());

        //act
        List<CharacterDTO> result = findController.find(query);

        //assert
        assertTrue(result.isEmpty());
        verify(findService, times(1)).find(any(String.class));
    }

}
