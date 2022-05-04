package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.ExceptionFactory;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.BeforeEach;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    @BeforeEach
    void setup() {
        this.writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
    }

    @Test
    public void analyzeScores() throws Exception {
        // Arrange
        Long payload = 1L;
        StudentDTO student = StudentFactory.studentJuanWithScores();
        String bodyJson = writer.writeValueAsString(student);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", payload);

        // Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType);
    }

    @Test
    public void analyzeScoresStudentNotFound() throws Exception {
        // Arrange
        Long payload = 200L;
        ErrorDTO exception = ExceptionFactory.studentNotFoundException(payload);
        String bodyJson = writer.writeValueAsString(exception);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", payload);

        // Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedStatus, expectedContentType);
    }
}
