package com.sprint.be_java_hisp_w15_g10.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test Endpoint para retornar una excepción al ingresar un id invalido")
    public void getInvalidUserWitFollowersCount() throws Exception {
        //arrange
        int userId = 0;
        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$.name").value("VALIDATION EXCEPTION"))
                .andExpect(jsonPath("$.message").value("getUserWitFollowersCount.userId: El id debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Test Endpoint para retornar un usuario con un conteo de seguidores")
    public void getUserWitFollowersCount() throws Exception {
        //arrange
        int userId = 1;
        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Alejandro"))
                .andExpect(jsonPath("$.followers_count").value(0));
    }

    @Test
    @DisplayName("Test Endpoint para retornar una excepción al ingresar usuario no encontrado")
    public void getNotFoundUserWitFollowersCount() throws Exception {
        //arrange
        int userId = 100;
        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$.name").value("NOT FOUND USER"))
                .andExpect(jsonPath("$.message").value("El usuario no fue encontrado"));
    }

    @Test
    @DisplayName("Test de integracion de obtener seguidores de usuario")
    void testGetVendorsFollow() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", Matchers.hasSize(0)));
    }

    /**
     * Valida que se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integracion de seguir a un usuario")
    void followUserIntegrationTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Arrange

        int userId = 1;
        int followedId = 2;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/follow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$.message").value("Se ha comenzado a seguir al usuario: Camilo"));
    }

    /**
     * Valida que se no se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integracion de seguir a un usuario")
    void followUserInvalidIntegrationTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Arrange

        int userId = 10;
        int followedId = 2;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/follow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$.message").value("El usuario no fue encontrado"));
    }

}
