package com.bootcamp.be_java_hisp_w15_g02.integration.controller;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test integral para seguir a un vendedor.")
    void testFollow() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        String messageConfirm = "Seguidor anadido";

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8");
        ResultMatcher expectedResponse = MockMvcResultMatchers.content().string(messageConfirm);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",4,5);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedResponse,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Test integral para dejar de seguir a un vendedor.")
    void testunFollow() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        String messageConfirm = "Dejo de seguir al user: 5";

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8");
        ResultMatcher expectedResponse = MockMvcResultMatchers.content().string(messageConfirm);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}",4,5);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedResponse,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Test integral para obtener la lista de seguidos de un cliente.")
    void testFolloweds() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        var followed1 = new GetFollowersDTO();
        var followed2 = new GetFollowersDTO();

        followed1.setUserId(4);
        followed1.setUserName("Carlos");

        followed2.setUserId(5);
        followed2.setUserName("Ramiro");

        var listFolloweds = new ArrayList<GetFollowersDTO>();

        listFolloweds.add(followed1);
        listFolloweds.add(followed2);

        var responseExpected = new GetFollowedByUserDTO(1,"Martin",listFolloweds);

        responseExpected.setFollowed(listFolloweds);

        String jsonExpected = writer.writeValueAsString(responseExpected);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",1);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Test integral para obtener la lista de seguidores de un vendedor.")
    void testFollowers() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        var follower1 = new GetFollowersDTO();
        var follower3 = new GetFollowersDTO();

        follower1.setUserId(1);
        follower1.setUserName("Martin");

        follower3.setUserId(3);
        follower3.setUserName("Leo");

        var listFollowers = new ArrayList<GetFollowersDTO>();

        listFollowers.add(follower1);
        listFollowers.add(follower3);

        var responseExpected = new GetFollowersBySellerDTO(4,"Carlos",listFollowers);

        responseExpected.setFollowers(listFollowers);

        String jsonExpected = writer.writeValueAsString(responseExpected);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",4);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Test integral para obtener la cantidad de seguidores de un usuario.")
    void testFollowersCount() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        var responseExpected = new GetFollowersCountDTO(4,"Carlos",2);

        String jsonExpected = writer.writeValueAsString(responseExpected);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",4);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }
}
