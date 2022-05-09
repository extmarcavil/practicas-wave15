package com.sprint1.be_java_hisp_w15_g03_acosta.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.Seller;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.User;
import com.sprint1.be_java_hisp_w15_g03_acosta.repository.MeliRepository;
import com.sprint1.be_java_hisp_w15_g03_acosta.util.PersonFactor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Test de integracion del controlador UserController
 */

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static MeliRepository meliRepository = new MeliRepository();

    List<User> users;
    List<Seller> sellers;
    ObjectWriter writer;

    @BeforeEach
    public void setUp(){
        this.writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer();

        users = PersonFactor.users();
        sellers = PersonFactor.sellers();
        meliRepository.loadDataTest(sellers, users);

    }

    //Reseteo de datos en Repositorio para que los datos no se carguen nuevamente en cada BeforeEach
    @AfterEach
    public void resetSetUp(){
        meliRepository.resetDataTest(sellers, users);
    }


    //Test de Integracion de US-0001
    @Test
    @DisplayName("Seguir un vendedor correcto")
    public void followSellerOk() throws Exception{

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // act & assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 3))
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
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 80))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    //Test de Integracion de US-0002
    @Test
    @DisplayName("Cantidad de usuarios que siguen a un vendedor correcto")
    public void getFollowCountOk() throws Exception{

        //arrange
        meliRepository.followSeller(1, 3);
        meliRepository.followSeller(3, 3);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = content().contentType("application/json");
        ResultMatcher expectedValue = jsonPath("$.followersCount").value(2);

        // act & assert
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
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
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", 60))
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
                MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnFollow}", 1, 5))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    //Test de Integracion de US-0003
    @Test
    @DisplayName("Listado de usuarios que siguen a un vendedor correcto")
    public void getFollowersListOk() throws Exception{

        //arrange
        meliRepository.followSeller(3, 3);
        meliRepository.followSeller(4, 3);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = content().contentType("application/json");

        // act & assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list",
                3))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson
                )
                .andReturn()
        ;

        ObjectMapper map = new ObjectMapper();
        SellerFListDTO sellerListDTO = map.readValue(result.getResponse().getContentAsString(), SellerFListDTO.class);

        Assertions.assertEquals(sellerListDTO.getFollowers().size(), 2);
        Assertions.assertEquals(sellerListDTO.getFollowers().get(0).getUserName(), "Maria");
        Assertions.assertEquals(sellerListDTO.getFollowers().get(1).getUserName(), "Juan");
    }


    //Test de Integracion de US-0003
    @Test
    @DisplayName("Listado de usuarios que siguen a un vendedor con ID incorrecto")
    public void getFollowersListIncorrect() throws Exception{

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();
        ResultMatcher expectedJson = content().contentType("application/json");

        // act & assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list",
                60))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson
                )
                .andReturn()
                ;
    }


    //Test de Integracion de US-0004
    @Test
    @DisplayName("Listado de todos los vendedores que sigue un determinado usuario")
    public void getFollowedListOk() throws Exception{

        //arrange
        meliRepository.followSeller(3, 3);
        meliRepository.followSeller(3, 4);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = content().contentType("application/json");

        // act & assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list",
                3))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson
                )
                .andReturn()
                ;

        ObjectMapper map = new ObjectMapper();
        UserListDTO userListDTO = map.readValue(result.getResponse().getContentAsString(), UserListDTO.class);

        Assertions.assertEquals(userListDTO.getFollowed().size(), 2);
        Assertions.assertEquals(userListDTO.getFollowed().get(0).getUserName(), "Garbarino");
        Assertions.assertEquals(userListDTO.getFollowed().get(1).getUserName(), "Musimundo");
    }

}
