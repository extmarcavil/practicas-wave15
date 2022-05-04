package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HouseDTOTest {

    @Test
    void verifyHouseResponseDTO(){

        //arrange
        RoomDTO room1 = new RoomDTO();
        room1.setName("Room1");
        room1.setLength(5);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Room2");
        room2.setLength(10);
        room2.setWidth(10);

        //act


        //assert
        assertAll(
                () -> assertEquals(room1.getSquareFeet(), 25),
                () -> assertEquals(room2.getSquareFeet(), 100)
        );
    }
}
