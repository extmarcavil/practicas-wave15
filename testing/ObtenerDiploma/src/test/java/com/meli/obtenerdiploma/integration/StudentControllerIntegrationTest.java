package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
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

import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static StudentDAO dao = new StudentDAO();


    @Test
    public void registerStudentTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        StudentDTO student = StudentFactory.createStudent();

        String json = writer.writeValueAsString(student);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void getStudentTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        StudentDTO student = StudentFactory.createStudent();
        student.setId(1L);

        String json = writer.writeValueAsString(student);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(json);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    public void cannotGetStudentTest() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                );
    }

    @Test
    public void modifyStudentTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        StudentDTO student = StudentFactory.createStudent2();

        String json = writer.writeValueAsString(student);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void removeStudentTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/removeStudent/{id}", 2);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void getListStudentsTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        Set<StudentDTO> students = StudentFactory.getAllStudents();

        String json = writer.writeValueAsString(students);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/listStudents");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(json);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

}
