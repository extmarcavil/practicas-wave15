package com.meli.obtenerdiploma.integration_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

@Test
@DisplayName("Obtener resultados de un estudiante por Id con promedio igual 9")
    void analyzeAversgeScoresTestOk() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",2))
            .andDo(print())
            .andExpectAll(
                status().isOk(),
                MockMvcResultMatchers.jsonPath("$.averageScore")
                        .value(9),
                    MockMvcResultMatchers.jsonPath("$.message")
                            .value("El alumno Pedro ha obtenido un promedio de 9. Puedes mejorar.")
            );

}

    @Test
    @DisplayName("Obtener resultados de un estudiante por Id que no existe")
    void analyzeScoresTestIdNotFount() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1000))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    @Test
    @DisplayName("Obtener resultados de un estudiante por Id con promedio menor a 9")
    void analyzeMessageScoresTestOk() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.averageScore")
                                .value(7.333333333333333),
                        MockMvcResultMatchers.jsonPath("$.message")
                                .value("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.")
                );

    }


}
