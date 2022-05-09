package com.example.be_java_hisp_w15_g07.integration.controller;

import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.service.IUserService;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    void setup(){
         this.writer =  new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("/users/{userId}/followers/count -> trae la cantidad de followers del usuario pasado por param")
    void countFollowersTest() throws Exception {
        // Arrange
        FollowersCountDTO count = new FollowersCountDTO(2, "User 2", 2);
        String countJson = writer.writeValueAsString(count);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(countJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act and Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("/users/{userId}/followers/count -> lanza excepción cuando no encuentra el usuario")
    void countFollowersFailsTest() throws Exception {
        String exceptionMessage = "Usuario no encontrado";
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 100);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBodyError= MockMvcResultMatchers.jsonPath("$.name").value(exceptionMessage);
        // Act and Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedBodyError
                );
    }

    @Test
    @DisplayName("/{userId}/follow/{userIdToFollow} -> devuelve un OK al intentar seguir un usuario")
    void followUserTest() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",2, 3);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // Act and Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );

    }

    @Test
    @DisplayName("/{userId}/follow/{userIdToFollow} -> lanza una excepción si el usuario no existe")
    void followUserFailsTest() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",-2, 3);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        // Act and Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    @DisplayName("/{userId}/followers/list -> un usuario obtiene su lista de seguidores")
    void getFollowersListTest() throws Exception {
        // Arrange
        Integer id = 2;
        FollowersDTO listOfFollowers = UserFactory.getFollowersDTODesc();
        String listJson = writer.writeValueAsString(listOfFollowers);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", id);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Act and Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }
}
