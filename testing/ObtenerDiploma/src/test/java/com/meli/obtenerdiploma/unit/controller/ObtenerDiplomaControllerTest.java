package com.meli.obtenerdiploma.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.data.Data;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ObtenerDiplomaController.class)
class ObtenerDiplomaControllerTest {

    /**
     * Injection of dependency con el Attribute (MockMvc)
     * es la implementacion de Mockito para probar un Controlador.
     * Ya viene Configurado Automaticamente con todos los contextos de prueba en Web para el Controller.
     */
    @Autowired
    private MockMvc mvc;

    /**
     * Definicion del @MockBean StudentService, ya que el Controller depende de este.
     */
    @MockBean
    private IObtenerDiplomaService obtenerDiplomaService;

    /**
     * Attribute ObjectMapper
     * Convertir Objetos a formato String/Json
     * objectMapper.writeValueAsString(Obj);
     */
    ObjectMapper objectMapper;

    /**
     * Method BeforeEach() del ciclo de vida
     * Para Inicializar el ObjectMapper
     */
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }


    /**
     * Test para analizar las notas de un estudiante.
     */
    @Test
    void analyzeScoresTest() throws Exception {
        //Arrange
        //when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(Data.STUDENT_DTO_4);
        doReturn(Data.STUDENT_DTO_4).when(obtenerDiplomaService).analyzeScores(anyLong());

        //Act
        mvc.perform(get("/analyzeScores/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("Ricardo"));

        //Assert
        assertEquals("Ricardo", obtenerDiplomaService.analyzeScores(4L).getStudentName());
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(4L);
        verify(obtenerDiplomaService, times(2)).analyzeScores(4L);
    }
}