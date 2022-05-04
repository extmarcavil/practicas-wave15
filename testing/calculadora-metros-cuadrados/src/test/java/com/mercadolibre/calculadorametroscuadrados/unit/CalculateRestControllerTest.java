package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

        @Mock
        private CalculateService calculateService;

        @InjectMocks
        private CalculateRestController calculateRestController;

        @Test
        void calculateValue(){
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

            HouseResponseDTO responseMock = new HouseResponseDTO();
            responseMock.setBiggest(room2);
            responseMock.setSquareFeet(125);
            responseMock.setName(houseDTO.getName());
            responseMock.setRooms(houseDTO.getRooms());
            responseMock.setPrice(100000);
            responseMock.setAddress(houseDTO.getAddress());

            when(calculateService.calculate(any(HouseDTO.class))).thenReturn(responseMock);

            //act
            HouseResponseDTO response = calculateRestController.calculate(houseDTO);

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
                    () -> assertEquals(response.getPrice(), 100000),
                    () -> verify(calculateService, times(1)).calculate(any(HouseDTO.class))
            );
        }
}
