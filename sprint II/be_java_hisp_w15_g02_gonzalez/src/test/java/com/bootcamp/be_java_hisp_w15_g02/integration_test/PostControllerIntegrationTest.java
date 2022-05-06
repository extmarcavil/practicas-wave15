package com.bootcamp.be_java_hisp_w15_g02.integration_test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {

    }

    @Test
    @DisplayName("Usuario sigue a otro de manera exitosa")
    public void testFollowerUserByIdTest() throws Exception {
        //arrange
        Integer userId = 2;
        Integer userToFollowId = 4;
        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedBody = MockMvcResultMatchers.content().string("Seguidor anadido");
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.valueOf("text/plain;charset=UTF-8"));
        //request
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/{client_id}/follow/{seller_id}", userId, userToFollowId);
        //actAssert
        mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }


}
