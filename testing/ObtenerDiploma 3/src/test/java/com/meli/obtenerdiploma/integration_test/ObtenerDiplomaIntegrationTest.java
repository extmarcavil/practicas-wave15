package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    private IStudentRepository studentRepository;

    private ObjectWriter objectMapper;
    static StudentDAO studentDAO = new StudentDAO();

    SubjectDTO subject1, subject2, subject3, subject4;
    StudentDTO student1, student2;

    @BeforeEach
    public void beforEach() {
        objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        subject1 = new SubjectDTO("Matemática", 10.0);
        subject2 = new SubjectDTO("Física", 8.0);
        student1 = new StudentDTO(1L, "Jose", null, null, List.of(subject1, subject2));

        subject3 = new SubjectDTO("Quimíca", 10.0);
        subject4 = new SubjectDTO("Lengua", 8.0);
        student2 = new StudentDTO(2L, "Pedro", null, null, List.of(subject3, subject4));


    }

    @Test
    @DisplayName("Analizar un promedio con mensaje correcto Felicitaciones!")
    public void calculateExcellentAverage() throws Exception {

        //arrange
        Long id = 1L;

        //act

        //assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Jose"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Jose ha obtenido un promedio de 9.00. Felicitaciones!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9.0))
                .andReturn();
    }


}
