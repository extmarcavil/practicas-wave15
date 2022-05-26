package com.meli.obtenerdiploma.integration_test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.StudentDTOFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    //@MockBean
    //private StudentService studentService;
    /*public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.create(stu);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return this.studentService.read(id);
    }

    @PostMapping("/modifyStudent")
    public ResponseEntity<?> modifyStudent(@RequestBody @Valid StudentDTO stu) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/removeStudent/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/listStudents")
    public Set<StudentDTO> listStudents() {
    }*/
    @Test
    @DisplayName("demo test integration POST")
    void testPostRegisterUserSuccess() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        StudentDTO studentDTO1= StudentDTOFactory.createStudent();


        String studentPayload =
                writer.writeValueAsString(studentDTO1);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post(
                        "/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentPayload);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("demo test Obtener estudiante correcto GET")
    void testGetStudentSuccess() throws Exception {
        //Act
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",2))
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"),
                        MockMvcResultMatchers.jsonPath("$.subjects[:1].name").value("Matemática"),
                        MockMvcResultMatchers.jsonPath("$.subjects.length()").value(3)
                );
    }

    @Test
    @DisplayName("demo test Obtener estudiante GET")
    void testGetStudentFail() throws Exception {
        //Act
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1000000))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                    MockMvcResultMatchers.status().isNotFound(),
                    MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                    MockMvcResultMatchers.jsonPath("$.description")
                            .value("El alumno con Id 1000000 no se encuetra registrado.")
                );
        //Assert
    }

    @Test
    @DisplayName("demo test integration POST modificar usuario")
    void testPostModifyUserSuccess() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        StudentDTO studentDTO1= StudentDTOFactory.createStudent();


        String studentPayload =
                writer.writeValueAsString(studentDTO1);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post(
                        "/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentPayload);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("demo test Eliminar un estudiante correcto GET")
    void testDeleteStudentSuccess() throws Exception {
        //Act
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",2))
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk()
                );
    }

    @Test
    @DisplayName("demo test obtener todos los estudiantes GET")
    void testGetAllStudentSuccess() throws Exception {
        //Set<StudentDTO> expectedStudents
        //Act
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.length()", is(2)),
                        MockMvcResultMatchers.jsonPath("$").isArray()
                );
    }



}
