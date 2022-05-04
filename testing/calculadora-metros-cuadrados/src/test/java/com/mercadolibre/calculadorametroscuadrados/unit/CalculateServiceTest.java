package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateServiceTest {

    static private CalculateService calculateService;

    @BeforeAll
    static void setUp() {
        calculateService = new CalculateService();
    }

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

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House1");
        houseDTO.setAddress("an address");
        houseDTO.setRooms(List.of(room1, room2));

        //act
        HouseResponseDTO response = calculateService.calculate(houseDTO);

        //assert
        assertAll(
                () -> assertEquals(response.getSquareFeet(), 125),
                () -> assertEquals(response.getBiggest(), room2),
                () -> assertEquals(response.getName(), houseDTO.getName()),
                () -> assertEquals(response.getAddress(), houseDTO.getAddress()),
                () -> assertEquals(response.getRooms().size(), houseDTO.getRooms().size()),
                () -> {
                    for (int i = 0; i < response.getRooms().size(); i++) {
                        assertTrue(response.getRooms().contains(houseDTO.getRooms().get(i)));
                    }
                },
                () -> assertEquals(response.getPrice(), 100000)
        );
    }
}
