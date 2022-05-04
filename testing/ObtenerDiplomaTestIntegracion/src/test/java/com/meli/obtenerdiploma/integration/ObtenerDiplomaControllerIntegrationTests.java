package com.meli.obtenerdiploma.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void analizeScoreWithPathVariableTest() throws Exception{
        /*ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        ArrayList<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(new SubjectDTO("Matemática", 9.0));
        listSubject.add(new SubjectDTO("Física", 7.0));
        listSubject.add(new SubjectDTO("Química", 6.0));
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, listSubject);

        String studentJSON = writer.writeValueAsString(studentDTO);

         */

        mockMvc.perform(get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.averageScore").value(7.333333333333333));
                //.andExpect(content().json(studentJSON));
    }
}
