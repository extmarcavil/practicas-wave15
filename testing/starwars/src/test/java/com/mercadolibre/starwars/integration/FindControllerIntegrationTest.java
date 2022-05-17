package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void find() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .writer();

        //Arreange
        List<CharacterDTO> expected = Utils.listasPorNombre();
        String expectedString = writer.writeValueAsString(expected);
        String query = "Darth";

        // Expected
        ResultMatcher expextedJson = MockMvcResultMatchers.content().json(expectedString);
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/{query}", query);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expextedJson)
                .andExpect(expextedStatus)
        ;


    }
}
