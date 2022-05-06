package com.sprint1.be_java_hisp_w15_g03_acosta.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.Seller;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.User;
import com.sprint1.be_java_hisp_w15_g03_acosta.repository.MeliRepository;
import com.sprint1.be_java_hisp_w15_g03_acosta.util.PersonFactor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    static MeliRepository meliRepository = new MeliRepository();

    @BeforeEach
    public void setUp(){

        List<User> users = PersonFactor.users();
        List<Seller> sellers = PersonFactor.sellers();
        meliRepository.loadDataTest(sellers, users);

    }


    //Test de Integracion de US-0001
    @Test
    @DisplayName("Seguir un vendedor correcto")
    public void followSellerOk() throws Exception{

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // act & assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(expectedStatus);
    }

    //Test de Integracion de US-0001
    @Test
    @DisplayName("Seguir un vendedor que no existe")
    public void followSellerInvalid() throws Exception{

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        // act & assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 400))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    //Test de Integracion de US-0002
    @Test
    @DisplayName("Cantidad de usuarios que siguen a un vendedor correcto")
    public void getFollowCountOk() throws Exception{

        //arrange
        meliRepository.followSeller(1, 2);
        meliRepository.followSeller(3, 2);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = content().contentType("application/json");
        ResultMatcher expectedValue = jsonPath("$.followers_count").value(2);

        // act & assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedValue
                );
    }

    //Test de Integracion de US-0002
    @Test
    @DisplayName("Cantidad de usuarios que siguen a un vendedor inexistente")
    public void getFollowCountInvalid() throws Exception{

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();
        ResultMatcher expectedJson = content().contentType("application/json");

        // act & assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", 100))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson
                );
    }

    //Test de Integracion de US-0007
    @Test
    @DisplayName("Dejar de seguir a un determinado vendedor - correcto")
    public void unFollowSellerOk() throws Exception{

        //Expected
        meliRepository.followSeller(1, 3);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // act & assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnFollow}", 1, 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    //Test de Integracion de US-0007
    @Test
    @DisplayName("Dejar de seguir a un determinado vendedor - con vendedor ID inexistente")
    public void unFollowSellerIncorrect() throws Exception{

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        // act & assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnFollow}", 1, 400))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

}
