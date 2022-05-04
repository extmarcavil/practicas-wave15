package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    static private ObjectWriter objectMapper;

    @BeforeAll
    static void setUp() {
        objectMapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    }

    @Test
    public void calculateValue() throws Exception {

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

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setBiggest(room2);
        houseResponseDTO.setSquareFeet(125);
        houseResponseDTO.setName(houseDTO.getName());
        houseResponseDTO.setRooms(houseDTO.getRooms());
        houseResponseDTO.setPrice(100000);
        houseResponseDTO.setAddress(houseDTO.getAddress());

        String houseDTOJSON = objectMapper.writeValueAsString(houseDTO);
        String houseResponseDTOJSON = objectMapper.writeValueAsString(houseResponseDTO);

        //act


        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseDTOJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(houseResponseDTOJSON))
                .andReturn();
    }
}
