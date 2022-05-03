package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

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
    public void listStudentsTest() throws Exception {
        //arrange


        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(studentRepository.findAll())))
                .andReturn();
    }

    @Test
    public void deleteStudentById() throws Exception {
        //arrange
        Long id = 1L;
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/removeStudent/{id}",id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void createStudentSuccessfully() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "Juan", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void createStudentWithoutName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, null, null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithEmptyName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithInvalidName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithoutSubjects() throws Exception {
        //arrange

        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, null);

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithEmptySubjects() throws Exception {
        //arrange
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, new ArrayList<>());

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithoutSubjectName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO(null, 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithEmptySubjectName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithInvalidSubjectName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("aMatemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithNegativeNote() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", -0.1d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void createStudentWithNoteMayorThan10() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.1d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
    @Test
    void createStudentWithoutNote() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", null);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(null, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void findByIdExistentStudent() throws Exception {
        //arrange
        Long id = 2L;
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void findByIdNotExistentStudent() throws Exception {
        //arrange
        Long id = -1L;
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void modifyStudentSuccessfully() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void modifyStudentWithoutName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, null, null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithEmptyName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithInvalidName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithoutSubjects() throws Exception {
        //arrange

        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, null);

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithEmptySubjects() throws Exception {
        //arrange
        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, new ArrayList<>());

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithoutSubjectName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO(null, 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithEmptySubjectName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithInvalidSubjectName() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("aMatemática", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithNegativeNote() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", -0.1d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void modifyStudentWithNoteMayorThan10() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.1d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
    @Test
    void modifyStudentWithoutNote() throws Exception {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", null);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7d);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6d);
        StudentDTO studentDTO = new StudentDTO(1L, "aTomas", null, null, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

}
