package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.DecimalFormat;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test de guardado correcto de un Student")
    void registerStudentOk() throws Exception {
        ObjectWriter writer= new ObjectMapper()
                .writer();

        StudentDTO dto= StudentFactory.getJuan();
        String jsonDto= writer.writeValueAsString(dto);

        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDto);

        mockMvc.perform(req)
                .andExpectAll(
                        status
                );
    }

    @Test
    @DisplayName("Test de Error debido al nombre del estudiante")
    void registerStudentNotOkBecauseNameStudent() throws Exception {
        ObjectWriter writer= new ObjectMapper()
                .writer();

        StudentDTO dto= StudentFactory.getJuan();
        dto.setStudentName("juan");
        String jsonDto= writer.writeValueAsString(dto);


        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher nameError= MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException");

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDto);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        nameError
                );
    }

    @Test
    @DisplayName("Test de Error debido al nombre de una materia")
    void registerStudentNotOkBecauseNameSubject() throws Exception {
        ObjectWriter writer= new ObjectMapper()
                .writer();

        StudentDTO dto= StudentFactory.getJuan();
        dto.getSubjects().get(2).setName("Algo");

        String jsonDto= writer.writeValueAsString(dto);


        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher nameError= MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException");

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDto);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        nameError
                );
    }


    @Test
    @DisplayName("Modificacion de un Student")
    void modifyStudentOk() throws Exception {
        ObjectWriter writer= new ObjectMapper()
                .writer();

        StudentDTO dto= StudentFactory.getJuan();
        dto.getSubjects().get(2).setName("Algo");

        String jsonDto= writer.writeValueAsString(dto);


        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDto);

        mockMvc.perform(req)
                .andExpectAll(
                        status
                );
    }


    @Test
    @DisplayName("Test de Error debido al nombre del estudiante")
    void modifyStudentNotOkBecauseNameStudent() throws Exception {
        ObjectWriter writer= new ObjectMapper()
                .writer();

        StudentDTO dto= StudentFactory.getJuan();
        dto.setStudentName("juan");
        String jsonDto= writer.writeValueAsString(dto);


        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher nameError= MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException");

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDto);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        nameError
                );
    }

    @Test
    @DisplayName("Modificacion de un Student, deberia fallar por el nombre de la materia")
    void modifyStudentNotOkBecauseSubjectBadName() throws Exception {
        ObjectWriter writer= new ObjectMapper()
                .writer();

        StudentDTO dto= StudentFactory.getJuan();
        dto.getSubjects().get(2).setName("algo");

        String jsonDto= writer.writeValueAsString(dto);


        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher nameError= MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException");

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDto);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        nameError
                );
    }

    @Test
    @DisplayName("Delete")
    void removeStudentOk() throws Exception {

        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/removeStudent/{id}",1);

        mockMvc.perform(req)
                .andExpectAll(
                        status
                );
    }

    //Notificar mediante body o bad request que no se encontro el student a borrar
    @Test
    @DisplayName("Borrado de un student no encontrad")
    void removeStudentNotOk() throws Exception {

        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isBadRequest();

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/removeStudent/{id}",19);

        mockMvc.perform(req)
                .andExpectAll(
                        status
                );
    }

    @Test
    @DisplayName("Obtencion de un Student")
    void getStudentOk() throws Exception {
        ObjectWriter writer = new ObjectMapper().writer();

        StudentDTO dtoExpected= StudentFactory.getJuan();

        String jsonDtoExpected=writer.writeValueAsString(dtoExpected);

        ResultMatcher status= MockMvcResultMatchers.status().isOk();
        ResultMatcher json= MockMvcResultMatchers.content().json(jsonDtoExpected);
        ResultMatcher contentType=MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder req= MockMvcRequestBuilders.get("/student/getStudent/{id}",1);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        json,
                        contentType
                );
    }

    @Test
    @DisplayName("Obtencion de un Student")
    void getStudentNotOk() throws Exception {
        ObjectWriter writer = new ObjectMapper().writer();


        ResultMatcher status= MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentType=MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBody= MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException");

        MockHttpServletRequestBuilder req= MockMvcRequestBuilders.get("/student/getStudent/{id}",7);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        contentType,
                        statusBody
                );
    }

}
