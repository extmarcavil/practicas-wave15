package com.be.java.hisp.w156.be.java.hisp.w156.integration_test;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName(" [Integration Test] - Obtener la cantidad de seguidores ")
    void whenGetCountFollowers_thenReturnAJSONWithCount() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        Integer userId = 3;
        String userName = "Dardo";
        Integer userFollowersCount = 2;

        UserCountFollowersDTO userCountFollowersDTO = new UserCountFollowersDTO(userId,userName,userFollowersCount);
        String listJson = writer.writeValueAsString(userCountFollowersDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);

        // ACT & Assert
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
    @DisplayName(" [Integration Test] - Listar los seguidores de un usuario ")
    void whenListAFollowers_thenReturnAJSONWithList() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        UserDTO userDTO = new UserDTO(1,"Pepe");
        UserDTO userDTO1 = new UserDTO(2,"Moni");
        List<UserDTO> followers = new ArrayList<>();
        followers.add(userDTO);
        followers.add(userDTO1);

        Integer userId = 3;
        String userName = "Dardo";
        UserFollowersDTO userFollowersDTO = new UserFollowersDTO(userId,userName,followers);

        String listJson = writer.writeValueAsString(userFollowersDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId);
                                                                        //.param("order", orderParam);

        // ACT & Assert
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
    @DisplayName(" [Integration Test] - Listar los seguidos de un usuario")
    void whenListAFollowed_thenReturnAJSONWithList() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        UserDTO userDTO = new UserDTO(3,"Dardo");
        UserDTO userDTO1 = new UserDTO(4,"Marialena");
        List<UserDTO> followeds = new ArrayList<>();
        followeds.add(userDTO);
        followeds.add(userDTO1);

        Integer userId = 1;
        String userName = "Pepe";
        UserFollowedDTO userFollowedDTO = new UserFollowedDTO(userId,userName,followeds);

        String listJson = writer.writeValueAsString(userFollowedDTO);

        //System.out.println(listJson);
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId);
                //.param("order", orderParam);

        // ACT & Assert
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
    @DisplayName(" [Integration Test] - Seguir a un usuario existente y retornar mensaje de éxito")
    void whenFollow_thenReturnAMessageSuccessfull() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        Integer userId = 1;
        Integer userIdFollow = 2;

        SuccessDTO successDTO = new SuccessDTO("The id user: 1 had follow user 2");
        String expectedBody = writer.writeValueAsString(successDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userId,userIdFollow);

        // act & assert
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
    @DisplayName(" [Integration Test] - Seguirse a si mismo y retornar mensaje de error")
    void whenFollowHimself_thenReturnAMessageError() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        Integer userId = 1;
        Integer userIdFollow = 1;

        ErrorDTO errorDTO = new ErrorDTO("UserCantFollowHimselfException","El usuario no puede seguirse a si mismo.");
        String expectedBody = writer.writeValueAsString(errorDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userId,userIdFollow);

        // act & assert
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
    @DisplayName(" [Integration Test] - Seguir a un usuario que ya seguía y retornar mensaje de error")
    void whenFollowAlReadyFollower_thenReturnAMessageError() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        Integer userId = 1;
        Integer userIdFollow = 3;

        ErrorDTO errorDTO = new ErrorDTO("UserAlreadyFollowsTheUserException","El usuario " + userId + " ya sigue al usuario " + userIdFollow);
        String expectedBody = writer.writeValueAsString(errorDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userId,userIdFollow);

        // act & assert
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
    @DisplayName(" [Integration Test] - Seguir a un usuario inexistente y retornar mensaje de error")
    void whenFollowWrongUser_thenReturnMessageError() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        Integer userId = 2;
        Integer userIdFollow = 8;

        ErrorDTO errorDTO = new ErrorDTO("UserNotFoundException","El usuario con ID: " + userIdFollow + " no fue encontrado");
        String expectedBody = writer.writeValueAsString(errorDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userId,userIdFollow);

        // act & assert
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
    @DisplayName(" [Integration Test] - Dejar de seguir a un usuario y retornar mensaje de éxito")
    void whenUnfollow_returnMessageSuccessfull() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        Integer userId = 1;
        Integer userIdUnfollow = 4;

        SuccessDTO successDTO = new SuccessDTO("The id user: " + userId + " had unfollow user " + userIdUnfollow);
        String expectedBody = writer.writeValueAsString(successDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",userId,userIdUnfollow);

        // act & assert
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
    @DisplayName(" [Integration Test] - Dejar de seguir a un usuario que no seguía y retornar mensaje de error")
    void whenUnfollowWrongUser_thenReturnMessageError() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        Integer userId = 1;
        Integer userIdUnfollow = 2;

        ErrorDTO errorDTO = new ErrorDTO("UserNotFollowedException","El usuario " + userId + " no seguía al usuario " + userIdUnfollow);
        String expectedBody = writer.writeValueAsString(errorDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",userId,userIdUnfollow);

        // act & assert
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
