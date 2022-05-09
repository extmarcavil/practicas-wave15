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
    @DisplayName("Test de integración de obtener seguidores de usuario")
    void testGetVendorsFollow() throws Exception {
        int id = 1;

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2);
        mockMvc.perform(request);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //REQUEST
        request =MockMvcRequestBuilders.get("/users/{userId}/followed/list", id);

        mockMvc.perform(request)
                .andDo(print()).andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", Matchers.hasSize(1)));
    }

    @Test
    @DisplayName("Test de integración de obtener seguidores de usuario")
    void testGetInvalidVendorsFollow() throws Exception {
        int id=0;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        //REQUEST
        MockHttpServletRequestBuilder request =MockMvcRequestBuilders.get("/users/{userId}/followed/list", id);

        mockMvc.perform(request)
                .andDo(print()).andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("VALIDATION EXCEPTION"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("getVendorsFollow.userId: El id debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Test de integración de obtener seguidores de usuario")
    void testGetNotFoundVendorsFollow() throws Exception {
        int id=10;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        //REQUEST
        MockHttpServletRequestBuilder request =MockMvcRequestBuilders.get("/users/{userId}/followed/list", id);

        mockMvc.perform(request)
                .andDo(print()).andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NOT FOUND USER"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario no fue encontrado"));
    }

    /**
     * Valida que se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integración de seguir a un usuario")
    void followUserIntegrationTest() throws Exception {

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
    @DisplayName("Test de integración de seguir a un usuario")
    void followUserNotFoundIntegrationTest() throws Exception {

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
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NOT FOUND USER"))
                .andExpect(jsonPath("$.message").value("El usuario no fue encontrado"));
    }

    /**
     * Valida que se no se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integracion de seguir a un usuario")
    void followUserNotFoundFollowedIntegrationTest() throws Exception {

        //Arrange

        int userId = 1;
        int followedId = 10;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/follow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NOT FOUND USER"))
                .andExpect(jsonPath("$.message").value("El usuario no fue encontrado"));
    }


    /**
     * Valida que se no se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integracion de seguir a un usuario")
    void followUserInvalidIntegrationTest() throws Exception {

        //Arrange

        int userId = 0;
        int followedId = 2;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/follow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("VALIDATION EXCEPTION"))
                .andExpect(jsonPath("$.message").value("followUser.userId: El id debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Test de integracion de seguir a un usuario ya seguido")
    void followFolowedUserIntegrationTest() throws Exception {

        //Arrange

        int userId = 1;
        int followedId = 2;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/follow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request);
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("FOLLOWS USER"))
                .andExpect(jsonPath("$.message").value("Usted ya sigue a: Camilo"));
    }

    /**
     * Valida que se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integración para dejar de seguir a un usuario")
    void unfollowUserIntegrationTest() throws Exception {

        //Arrange

        int userId = 1;
        int followedId = 2;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/follow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request);
        //REQUEST
        request = MockMvcRequestBuilders.post
                ("/users/{userId}/unfollow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$.message").value("Se ha dejado de seguir al usuario: Camilo"));
    }

    /**
     * Valida que se no se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integración para dejar de seguir a un usuario no encontrado")
    void unfollowUserNotFoundIntegrationTest() throws Exception {

        //Arrange

        int userId = 10;
        int followedId = 2;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/unfollow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NOT FOUND USER"))
                .andExpect(jsonPath("$.message").value("El usuario no fue encontrado"));
    }

    /**
     * Valida que se no se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integración para dejar de seguir a un usuario no encontrado")
    void unfollowUserNotFoundFollowedIntegrationTest() throws Exception {

        //Arrange

        int userId = 1;
        int followedId = 10;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/unfollow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NOT FOUND USER"))
                .andExpect(jsonPath("$.message").value("El usuario no fue encontrado"));
    }


    /**
     * Valida que se no se pueda seguir a un usuario dado el id del usuario y el id del usuario a seguir
     */
    @Test
    @DisplayName("Test de integración para dejar de seguir a un usuario con id menor a 0")
    void unfollowUserInvalidIntegrationTest() throws Exception {

        //Arrange

        int userId = 0;
        int followedId = 2;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/unfollow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("VALIDATION EXCEPTION"))
                .andExpect(jsonPath("$.message").value("unfollowUser.userId: El id debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Test de integración para dejar de seguir a un usuario que no se sigue")
    void unfollowFolowedUserIntegrationTest() throws Exception {

        //Arrange

        int userId = 1;
        int followedId = 2;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post
                ("/users/{userId}/unfollow/{userIdToFollow}", userId, followedId);

        //Assert
        mockMvc.perform(request);
        mockMvc.perform(request).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NOT FOLLOWS USER"))
                .andExpect(jsonPath("$.message").value("Usted no sigue a: Camilo"));
    }

}
