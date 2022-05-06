package com.example.be_java_hisp_w15_g07.integration;


import com.example.be_java_hisp_w15_g07.dto.response.ErrorDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowersDTO;
import com.example.be_java_hisp_w15_g07.repository.UserRepository;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        UserRepository.initDatabase();
    }


    @Test
    @DisplayName("Verificar que devuelva correctamente la cantidad de seguidores")
    void returnFollowersCount() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        //arrange
        int userId = 2;
        String userName = "User 2";
        int followersCount = 2;
        FollowersCountDTO expectedResponse = new FollowersCountDTO(userId, userName, followersCount);
        String jsonExpected = writer.writeValueAsString(expectedResponse);

        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);

        //act and assert
        mockMvc.
                perform(request).
                andDo(MockMvcResultHandlers.print()).
                andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Verificar que devuelva correctamente la lista de seguidores")
    void returnFollowersList() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        //arrange
        int userId = 2;
        String userName = "User 2";
        int userFollower1 = 1;
        String userFollowerName1 = "User 1";
        int userFollower3 = 3;
        String userFollowerName3 = "User 3";
        UserFollowersDTO follower1 = new UserFollowersDTO(userFollower1, userFollowerName1);
        UserFollowersDTO follower3 = new UserFollowersDTO(userFollower3, userFollowerName3);
        List<UserFollowersDTO> followersList = List.of(follower1, follower3);
        FollowersDTO expectedDto = new FollowersDTO(userId, userName, followersList);
        String jsonExpected = writer.writeValueAsString(expectedDto);

        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId);

        //act and assert
        mockMvc.
                perform(request).
                andDo(MockMvcResultHandlers.print()).
                andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Deja de seguir a un usuario")
    void unfollowsUser() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        //arrange
        int userId = 1;
        int unfollowedId = 2;

        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{unfollow}", userId, unfollowedId);

        //act and assert
        mockMvc.
                perform(request).
                andDo(MockMvcResultHandlers.print()).
                andExpectAll(
                        expectedStatus
                );
    }

    @Test
    @DisplayName("Deja de seguir a un usuario lanza excepción por id no encontrado")
    void unfollowsUserThrowsException() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        //arrange
        int userId = 1000; //IDs are always positive
        int unfollowedId = 2;
        ErrorDTO error = new ErrorDTO("Usuario no encontrado", "Usuario con id " + userId + " no encontrado.");
        String jsonError = writer.writeValueAsString(error);

        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonError);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{unfollow}", userId, unfollowedId);

        //act and assert
        mockMvc.
                perform(request).
                andDo(MockMvcResultHandlers.print()).
                andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Deja de seguir a un usuario lanza excepción por validación")
    void unfollowsUserThrowsValidationError() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        //arrange
        int userId = -1; //IDs are always positive
        int unfollowedId = 2;
        ErrorDTO error = new ErrorDTO("Petición inválida", "unfollowUser.userId: El id debe ser mayor a cero");
        String jsonError = writer.writeValueAsString(error);

        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonError);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{unfollow}", userId, unfollowedId);

        //act and assert
        mockMvc.
                perform(request).
                andDo(MockMvcResultHandlers.print()).
                andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }
}
