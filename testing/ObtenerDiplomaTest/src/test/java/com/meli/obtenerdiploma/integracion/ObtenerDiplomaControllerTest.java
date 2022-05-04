package com.meli.obtenerdiploma.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.meli.obtenerdiploma.utilidades.Utils.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Testeando el obtenerDiplomaController")
    void test1() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        String listJson = writer.writeValueAsString(newGoodStudent(2l,"jose"));

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = get("/analyzeScores/{studentId}", 2);

        // act & assert
        MvcResult result = mockMvc
                .perform(request)
                //.andDo(MockMvcResultHandlers.print()) si falla lo imprime igual
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType)
                .andReturn();
    }
}
