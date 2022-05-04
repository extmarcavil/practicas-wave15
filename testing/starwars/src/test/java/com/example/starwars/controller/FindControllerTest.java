package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    //Dependencias de la clase

    @Mock //indicamos el Mock
    private FindService mockFindService;

    @InjectMocks //Injectamos el mock a la clase
    private FindController findController;
    //Tests

    @Test
    void shouldFindCharacterByName(){
        //Arrage (Definimos test data e Input data)
        String query = "Darth";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Darth Vader");
        characterDTO1.setHair_color("Brown");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Darth Maul");
        characterDTO2.setHair_color("Black");

        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1,characterDTO2);
        when(mockFindService.find(query)).thenReturn(characterDTOList);

        //Act (Interactuamos conn la clase controller para ejecutar la logica)
        List<CharacterDTO> result = findController.find(query);

        //(Assert (Comprobar que los resultados obtenidos sean los esperados)A
        assertEquals(result.size(),2); // comprueba que la lista almacena 2 datos
        assertEquals(result.get(0).getName(),"Darth Vader"); //comprueba que la posicion 1 esta Vader
        verify(mockFindService, atLeastOnce()).find(query);
    }



}
