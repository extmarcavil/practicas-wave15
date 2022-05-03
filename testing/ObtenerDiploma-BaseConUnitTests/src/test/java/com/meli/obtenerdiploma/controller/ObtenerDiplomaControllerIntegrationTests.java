package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
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

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IStudentRepository studentRepository;

    private ObjectWriter objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void calculateExcellentAverage() throws Exception {
        //arrange
        Long id = 3L;

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(3L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Test ha obtenido un promedio de 9.00. Felicitaciones!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9D))
                .andReturn();
    }

    @Test
    public void calculateNotExcellentAverage() throws Exception {
        //arrange
        Long id = 2L;

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value((10+8+4)/3))
                .andReturn();
    }

    @Test
    public void calculateAverageNotExistentStudent() throws Exception {
        //arrange
        Long id = -3L;

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id " + id + " no se encuetra registrado."))
                .andReturn();
    }



}
