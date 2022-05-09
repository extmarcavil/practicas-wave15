package com.example.be_java_hisp_w15_g07.integration;

import com.example.be_java_hisp_w15_g07.dto.response.ErrorDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
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

@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("INDIVIDUAL - Verificar que se retorna correctamente la lista de seguidores.")
    void getFollowerListSuccess() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        Integer userId2 = 2;
        FollowersDTO followers = UserFactory.getFollowersDTOAsc();

        String listJson = writer.writeValueAsString(followers);

        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId2);

        //act & assert
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
    @DisplayName("BONUS - Verificar que se retorna correctamente la lista de seguidos.")
    void getFollowedListSuccess() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        Integer userId1 = 1;
        FollowedDTO followed = UserFactory.getFollowedDTOAsc();

        String listJson = writer.writeValueAsString(followed);

        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId1);

        //act & assert
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
    @DisplayName("INDIVIDUAL - Verificar que se retorna correctamente la lista en orden descendente de seguidores.")
    void getFollowerOrderDesc() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        Integer userId2 = 2;
        FollowersDTO followers = UserFactory.getFollowersDTODesc();

        String listJson = writer.writeValueAsString(followers);

        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", userId2)
                .param("order", "name_desc");

        //act & assert
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
    @DisplayName("INDIVIDUAL - Verificar que se retorna correctamente la lista en orden descendente de seguidos.")
    void getFollowedOrderDesc() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        Integer userId1 = 1;
        FollowedDTO followed = UserFactory.getFollowedDTODesc();

        String listJson = writer.writeValueAsString(followed);

        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", userId1)
                .param("order", "name_desc");

        //act & assert
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
    @DisplayName("BONUS - Verificar error al retornar usuario incorrecto (lista de seguidos).")
    void getFollowedListFailed() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        //Arrange
        Integer userId100 = 100;
        ErrorDTO error = new ErrorDTO("Usuario no encontrado", "Usuario con id 100 no encontrado.", null);

        String listJson = writer.writeValueAsString(error);

        //EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId100);

        //act & assert
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
