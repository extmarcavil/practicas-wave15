package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestFind {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Encontrar personajes con el nombre Luke")
    public void findAllCharacters() throws Exception{
        //arrange
        String query = "Luke";
        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}", query);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    @DisplayName("Encontrar personajes con el nombre Not found")
    public void notfindCharacters() throws Exception{
        //arrange
        String query = "Not found";
        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}", query);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
    }
}
