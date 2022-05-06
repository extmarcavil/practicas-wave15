package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.MakeStudentsDTO;
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

    @Test
    public void registerStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .writer();

        //Arrange
        StudentDTO student1 = MakeStudentsDTO.StudentDTOId1();
        String studentJson = writer.writeValueAsString(student1);

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
    }

    @Test
    public void getStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .writer();

        //Arrange
        StudentDTO student1 = MakeStudentsDTO.StudentDTOId1();
        String studentJson = writer.writeValueAsString(student1);

        //Expected
        ResultMatcher expecteJson = MockMvcResultMatchers.content().json(studentJson);
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/getStudent/{id}", 1);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus,
                        expecteJson
                );
    }

    @Test
    public void modifyStudent() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .writer();

        //Arrange
        StudentDTO student1 = MakeStudentsDTO.StudentDTOId1();
        String studentJson = writer.writeValueAsString(student1);

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
    }

    @Test
    public void removeStudent() throws Exception {
        //Arrange
        Long id = 1L;

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/removeStudent/{id}", id);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
    }

    @Test
    public void listStudents() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .writer();

        //Arrange
        Set<StudentDTO> students1 = MakeStudentsDTO.getStudentSet();
        String studentsJson = writer.writeValueAsString(students1);

        //Expected
        ResultMatcher expecteJson = MockMvcResultMatchers.content().json(studentsJson);
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/listStudents", 1);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus,
                        expecteJson
                );
    }


}
