package com.bootcamp.be_java_hisp_w15_g02.integration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class integrationTest {
    @Autowired
    MockMvc mock;


    @Test
    @DisplayName("Usuario trata de seguirse a si mismo")
    public void testUserFollowsItself() throws Exception {
        //arrange

        Integer userId = 2;

        //Expected

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        //Request

        MockHttpServletRequestBuilder mockRequestBuilder = MockMvcRequestBuilders.post("/users/{client_id}/follow/{seller_id}", userId, userId);

        //Act

        ResultActions act = mock.perform(mockRequestBuilder).andDo(MockMvcResultHandlers.print());

        //Assert

        act.andExpect(statusExpected).andExpect(jsonPath("$.message").value("No puede seguirse así mismo."));
    }

}
