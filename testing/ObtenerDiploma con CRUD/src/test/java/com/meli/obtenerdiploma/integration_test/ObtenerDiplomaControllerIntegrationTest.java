package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.StudentFactory;
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

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test de integración que valida el correcto cálculo del promedio de un estudiante.")
    void analyzeScoresReturnsOk() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        // Arrange
        StudentDTO stu = StudentFactory.createCarla();
        stu.setMessage("El alumno Carla ha obtenido un promedio de 8.5. Puedes mejorar.");
        stu.setAverageScore(8.5);

        String expectedBody = writer.writeValueAsString(stu);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", stu.getId());

        System.out.println(expectedJson);


        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);
    }

}
