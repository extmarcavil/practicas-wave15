package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.ObjectWriterFactory;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_registerStudent() throws Exception {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        String content = ObjectWriterFactory.create().writeValueAsString(s);

        // When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Then
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    public void test_getStudent() throws Exception {
        // Given
        ObjectWriter writer = ObjectWriterFactory.create();
        StudentDTO stuRes = StudentFactory.createStudentWithId2();
        String resJson = writer.writeValueAsString(stuRes);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(resJson);

        // When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/student/getStudent/{id}", 2);

        // Then
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedContentType, expectedJson);
    }

    @Test
    public void test_modifyStudent() throws Exception {
        // Given
        StudentDTO s = StudentFactory.createStraightAStudent();
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        String content = ObjectWriterFactory.create().writeValueAsString(s);

        // When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
  // "{\"user_id\":1,\"post_id\":10,\"date\":\"05-05-2022\",\"detail\":{\"product_id\":25,\"productName\":\"bmw z4\",\"type\":\"car\",\"brand\":\"bmw\",\"color\":\"black\",\"notes\":\"rumm rummm\"},\"category\":100,\"price\":10000.0}";
        // Then
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    public void test_removeStudent() throws Exception {
        // Given
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/student/removeStudent/{id}", 1);

        // Then
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus);
    }

    @Test
    public void test_listStudents() throws Exception {
        // Given
        Set<Long> ids = Set.of(2L,5L,1L,4L);
        ResultMatcher expected = jsonPath("$[:].ids").value(ids);

        // When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/student/listStudents");

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expected);
    }

}
