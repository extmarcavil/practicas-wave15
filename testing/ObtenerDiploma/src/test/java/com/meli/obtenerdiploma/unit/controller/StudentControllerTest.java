package com.meli.obtenerdiploma.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.data.Data;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentController.class)
class StudentControllerTest {

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
    private StudentService studentService;


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
     * Test para registrar un estudiante.
     */
    @Test
    void registerStudentTest() throws Exception {
        //Arrange
        doNothing().when(studentService).create(any(StudentDTO.class));

        //Act
        mvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Data.STUDENT_DTO_1)))
                .andExpect(status().isOk());

        //Assert

        verify(studentService, times(1)).create(Data.STUDENT_DTO_1);
        //verify(studentService, times(1)).create(any(StudentDTO.class));

    }

    /**
     * Test para obtener un estudiante por Id.
     */
    @Test
    void getStudentByIdTest() throws Exception {
        //Arrange
        doReturn(Data.STUDENT_DTO_4).when(studentService).read(anyLong());
        //doReturn(StudentDTO.class).when(studentService).read(anyLong());

        //Act
        mvc.perform(get("/student/getStudent/20"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("Ricardo"));
        //Assert
        verify(studentService, atLeastOnce()).read(anyLong());
        //verify(studentService, atLeastOnce()).read(4L);

    }

    /**
     * Test para modificar un estudiante.
     */
    @Test
    void modifyStudentTest() throws Exception {
        //Arrange
        doNothing().when(studentService).update(any(StudentDTO.class));

        //Act
        mvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Data.STUDENT_DTO_1)))
                .andExpect(status().isOk());

        //Assert
        verify(studentService, times(1)).update(Data.STUDENT_DTO_1);
        //verify(studentService, times(1)).update(any(StudentDTO.class));
    }

    /**
     * Eliminar un estudiante.
     */
    @Test
    void removeStudentTest() throws Exception {
        //Arrange
        doNothing().when(studentService).delete(anyLong());

        //Act
        mvc.perform(get("/student/removeStudent/1"))
                .andExpect(status().isOk());

        //Assert
        verify(studentService, times(1)).delete(1L);
        //verify(studentService, times(1)).delete(1L);
    }

    /**
     * Obteniendo la lista de estudiantes
     */
    @Test
    void listStudentsTest() throws Exception {
        //Arrange
        when(studentService.getAll()).thenReturn(Set.of(Data.STUDENT_DTO_1, Data.STUDENT_DTO_2));

        //Act
        mvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
        //.andExpect(jsonPath("$[1].studentName").value("Jorge"));

        //Assert
        assertEquals(2, studentService.getAll().size());
        //verify(studentService, times(2)).getAll();

    }
}