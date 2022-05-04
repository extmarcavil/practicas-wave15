package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
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

import javax.security.auth.Subject;
import java.io.StringWriter;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    StudentDTO student;

    @BeforeEach
    void setUp() {
        student = new StudentDTO();
        student.setId(1l);
        student.setStudentName("Juan");

        SubjectDTO subjects = new SubjectDTO();
        subjects.setScore(7d);
        subjects.setName("Física");

        SubjectDTO subjects2 = new SubjectDTO();
        subjects2.setScore(6d);
        subjects2.setName("Química");

        SubjectDTO subjects3 = new SubjectDTO();
        subjects3.setScore(9d);
        subjects3.setName("Matemática");

        student.setSubjects(List.of(subjects3, subjects, subjects2));

        double averageExpected = student.getSubjects().stream()
                .mapToDouble(SubjectDTO::getScore)
                .average()
                .getAsDouble();

        student.setAverageScore(averageExpected);
        student.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
    }

    @Test
    @DisplayName("Test for validate if return the correct user and parameter of this")
    public void ValidateUserDTOIfIsCorrect() throws Exception {
        // arrange
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        // Expected
        String expectedBody = writer.writeValueAsString(student);


        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1);

        //act and assert
       mockMvc
               .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedBody));

//        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

}
