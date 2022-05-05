package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void analizeScore() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        StudentDTO student = new StudentDTO();

        String response = writer.writeValueAsString(student);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(response);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        //normal
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", 1);

        // act & assert
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                )
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        StudentDTO r = objectMapper.readValue(result.getResponse().getContentAsString(), StudentDTO.class);
        Assertions.assertEquals(9D, r.getAverageScore());
    }

    @Test
    void analizeScoreStudentNotFound() throws Exception {
        //Arrange
        StudentDTO student = new StudentDTO();


        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        //normal
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", 4);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                );
    }
}
