package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Prueba");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Física", 6D);
        SubjectDTO subject1 = new SubjectDTO("Quimica", 6D);
        subjectDTOList.add(subject);
        subjectDTOList.add(subject1);

        student.setSubjects(subjectDTOList);

        String payload = writer.writeValueAsString(student);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Check nombre del estudiante")
    void registerStudentBadRequest() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        StudentDTO student = new StudentDTO();
        //Nombre debe ir con mayúscula
        student.setStudentName("prueba");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Física", 6D);
        SubjectDTO subject1 = new SubjectDTO("Quimica", 6D);
        subjectDTOList.add(subject);
        subjectDTOList.add(subject1);

        student.setSubjects(subjectDTOList);

        String payload = writer.writeValueAsString(student);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException)
                        );
    }

    @Test
    @DisplayName("")
    void registerStudentWithoutPayload() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Prueba");

        //La lista no deberia ser vacia;
        student.setSubjects(new ArrayList<>());

        String payload = writer.writeValueAsString(student);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON);
                //.content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof HttpMessageNotReadableException)
                );
    }

    @Test
    void deleteStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Prueba");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Física", 6D);
        SubjectDTO subject1 = new SubjectDTO("Quimica", 6D);
        subjectDTOList.add(subject);
        subjectDTOList.add(subject1);

        student.setSubjects(subjectDTOList);

        String payload = writer.writeValueAsString(student);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/student/removeStudent/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    void getStudent() throws Exception {
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
                .get("/student/getStudent/{id}", 1);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                );
    }

    @Test
    void getStudentNotFound() throws Exception {

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        //normal
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/student/getStudent/{id}", 4);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof StudentNotFoundException)
                );
    }

    @Test
    void modifyStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Prueba");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Física", 6D);
        SubjectDTO subject1 = new SubjectDTO("Quimica", 6D);
        subjectDTOList.add(subject);
        subjectDTOList.add(subject1);

        student.setSubjects(subjectDTOList);

        String payload = writer.writeValueAsString(student);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }


    @Test
    void listStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Prueba");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Física", 6D);
        SubjectDTO subject1 = new SubjectDTO("Quimica", 6D);
        subjectDTOList.add(subject);
        subjectDTOList.add(subject1);

        student.setSubjects(subjectDTOList);

        String payload = writer.writeValueAsString(student);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/student/listStudents");

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> {
                            Assertions.assertFalse(result.getResponse().getContentAsString().isEmpty());
                            }
                        );
    }

}
