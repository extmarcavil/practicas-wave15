package com.meli.obtenerdiploma.integration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.utils.Globals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName(" obtiene promedio de materias de un alumno")
    void getAnalyzeScoresStudent() throws Exception{
        //arr
        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(new SubjectDTO("Matematicas",9.0));
        listSubjects.add(new SubjectDTO("Español",9.0));
        StudentDTO result = new StudentDTO(1L,"Gerson","El alumno Gerson ha obtenido un promedio de 9. Puedes mejorar.",9.0,listSubjects);
        // act & assert
        mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().json(Globals.jsonFormat(result)),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
                );
    }

}
