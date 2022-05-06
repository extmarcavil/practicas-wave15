package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.MakeStudentsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void findById() throws Exception {
        // arrange
        ObjectWriter writer = new ObjectMapper()
                //.registerModule(new JavaTimeModule())//Convertir la fecha
                .writer();

        //Arrange
        StudentDTO student1 = MakeStudentsDTO.StudentDTOId1();
        String studentJson = writer.writeValueAsString(student1);

        //Expected
        // EXPECTED
        ResultMatcher expecteJson = MockMvcResultMatchers.content().json(studentJson);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders.get("/student/getStudent/{id}",1);

        //act & assert
        mockMvc
                .perform(req)
                //.andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }
}
