package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Registrar un nuevo estudiante")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void registerStudent() throws Exception  {
        // arrange
        StudentDTO payloadDTO = StudentFactory.getStudentWith3Subjects("Lucia");

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Obtener un estudiante por Id")
    public void getStudentOk() throws Exception {
        StudentDTO expected = StudentFactory.getStudentPedroInJson();

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        String expectedBody = writer.writeValueAsString(expected);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", expected.getId()))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.content().json(expectedBody)
                );
    }

    @Test
    @DisplayName("Modificar un estudiante")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void modifyStudentOk() throws Exception {
        StudentDTO student = StudentFactory.getStudentJuanInJson();
        student.setStudentName("Juan Carlos");

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        String payloadJson = writer.writeValueAsString(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Eliminar un estudiante por Id")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void removeStudentOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Obtener lista de estudiantes")
    public void getStudentsList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2))
                );
    }
}
