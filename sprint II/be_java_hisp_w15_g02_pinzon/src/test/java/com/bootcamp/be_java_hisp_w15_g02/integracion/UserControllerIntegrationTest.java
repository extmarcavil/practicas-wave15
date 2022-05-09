package com.bootcamp.be_java_hisp_w15_g02.integracion;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.integracion.utils.GlobalIntegracionUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActionsDsl;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Test for validate if a user can follow other")
    public void validateIfUserCanBeFollow() throws Exception {
        // arrange
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();
        String expectedString = "Seguidor anadido";
        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedResult = MockMvcResultMatchers.content().string(expectedString);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 5);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedResult);

    }

    @Test
    @DisplayName("Test for validate the amount of users that follow ")
    public void validateAmountUserThatFollow() throws Exception {
        // arrange
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        // Expected
        GetFollowersCountDTO followerCountDTO = new GetFollowersCountDTO(5, "Ramiro", 3);

        String expectedString = writer.writeValueAsString(followerCountDTO);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedResult = MockMvcResultMatchers.content().string(expectedString);


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 5);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedResult);
    }

    @Test
    @DisplayName("Test for validate the followers are correct ")
    public void validateFollowersAreCorrect() throws Exception {

        // arrange
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        // Expected

        List<GetFollowersDTO> followers = GlobalIntegracionUtils.listFollowedUser();

        GetFollowersBySellerDTO followersBySellerDTO = new GetFollowersBySellerDTO(5, "Ramiro", followers);

        String expectedString = writer.writeValueAsString(followersBySellerDTO);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedResult = MockMvcResultMatchers.content().string(expectedString);


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", 5);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedResult);

    }

    @Test
    @DisplayName("Test for validate the followers are not correct ")
    public void validateFollowersAreNotCorrect() throws Exception {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", 10);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);

    }

    @Test
    @DisplayName("Test for validate the follower is not seller")
    public void validateFollowerIsNotSeller() throws Exception {

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
        .andExpect(expectedStatus);

    }

    @Test
    @DisplayName("Test for validate that no can't follow yourself ")
    public void validateCantFollowYourself() throws Exception {

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1);

        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);

    }

}
