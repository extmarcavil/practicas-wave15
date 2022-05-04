package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class IntegrationTestStudent {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    @AfterEach
    private void clear() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    @DisplayName("Agregar un alumno válido")
    public void registerValidStudent() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        //arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Luis");
        String studentPayload = writer.writeValueAsString(studentDTO);

        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentPayload);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    private void genericStudentValidation(StudentDTO studentDTO, String errorMessage) throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String studentPayload = writer.writeValueAsString(studentDTO);

        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher nameValue = jsonPath("$.name").value("MethodArgumentNotValidException");
        ResultMatcher descriptionValue = jsonPath("$.description").value(errorMessage);

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentPayload);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(nameValue)
                .andExpect(descriptionValue);
    }

    @Test
    @DisplayName("Agregar un alumno nulo")
    public void registerInvalidStudent() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects(null);
        genericStudentValidation(studentDTO, "El nombre del estudiante no puede estar vacío.");
    }

    @Test
    @DisplayName("Agregar un alumno con nombre invalido")
    public void registerInvalidNameStudent() throws Exception{
        //arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("luis");
        genericStudentValidation(studentDTO, "El nombre del estudiante debe comenzar con mayúscula.");
    }

    @Test
    @DisplayName("Agregar un alumno con nombre muy largo")
    public void registerOversizedNameStudent() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Luis David Rodriguez Benitez Luis David Rodriguez Benitez");
        genericStudentValidation(studentDTO, "La longitud del nombre del estudiante no puede superar los 50 caracteres.");
    }

    @Test
    @DisplayName("Agregar un alumno con una lista de materias vacía")
    public void registerEmptySubjectListStudent() throws Exception{
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Luis");
        genericStudentValidation(studentDTO, "La lista de materias no puede estar vacía.");
    }

    @Test
    @DisplayName("Agregar un alumno con un nombre de materia nulo")
    public void registerEmptySubjectNameStudent() throws Exception{
        //arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Luis David");
        studentDTO.getSubjects().get(0).setName(null);
        genericStudentValidation(studentDTO, "El nombre de la materia no puede estar vacío.");
    }

    @Test
    @DisplayName("Agregar un alumno con un nombre de materia invalido")
    public void registerInvalidSubjectNameStudent() throws Exception{
        //arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Luis David");
        studentDTO.getSubjects().get(0).setName("matemáticas");
        genericStudentValidation(studentDTO, "El nombre de la materia debe comenzar con mayúscula.");
    }

    @Test
    @DisplayName("Agregar un alumno con un nombre de materia muy largo")
    public void registerOversizedSubjectNameStudent() throws Exception{
        //arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Luis David");
        studentDTO.getSubjects().get(0).setName("Matemáticasmatemáticasmatemáticasmatemáticasmatemáticas");
        genericStudentValidation(studentDTO, "La longitud del nombre de la materia no puede superar los 30 caracteres.");
    }

    @Test
    @DisplayName("Agregar un alumno con un score de materia nulo")
    public void registerNullSubjectScoreStudent() throws Exception{
        //arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Luis David");
        studentDTO.getSubjects().get(0).setScore(null);
        genericStudentValidation(studentDTO, "La nota de la materia no puede estar vacía.");
    }

    @Test
    @DisplayName("Agregar un alumno con un score de materia por debajo del mínimo")
    public void registerUnderMinSubjectScoreStudent() throws Exception{
        //arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Luis David");
        studentDTO.getSubjects().get(0).setScore(-1.0);
        genericStudentValidation(studentDTO, "La nota mínima de la materia es de 0 pts.");
    }

    @Test
    @DisplayName("Agregar un alumno con un score de materia por encima del máximo")
    public void registerOverMaxSubjectScoreStudent() throws Exception{
        //arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Luis David");
        studentDTO.getSubjects().get(0).setScore(11.0);
        genericStudentValidation(studentDTO, "La nota máxima de la materia es de 10 pts.");
    }
}
