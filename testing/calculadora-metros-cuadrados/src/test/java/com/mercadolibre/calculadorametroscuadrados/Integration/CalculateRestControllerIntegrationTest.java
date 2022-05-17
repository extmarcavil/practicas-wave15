package com.mercadolibre.calculadorametroscuadrados.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void calculate () throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .writer();

        //Arrange
        HouseDTO houseDTO = Util.houseDTO();
        HouseResponseDTO expected = Util.houseResponseDTO();
        String expectedJson = writer.writeValueAsString(expected);
        String houseDTOString = writer.writeValueAsString(houseDTO);

        //Expected
        ResultMatcher expecteJson = MockMvcResultMatchers.content().json(expectedJson);
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(houseDTOString);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expextedStatus)
                .andExpect(expecteJson);

    }
}
