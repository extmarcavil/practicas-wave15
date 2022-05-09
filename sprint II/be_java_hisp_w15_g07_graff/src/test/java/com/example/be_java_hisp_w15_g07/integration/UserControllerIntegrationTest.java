package com.example.be_java_hisp_w15_g07.integration;

import com.example.be_java_hisp_w15_g07.dto.response.ErrorDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowersDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("TBONUS - Este Test prueba el retorno de la cuenta de seguiores")
    void countFollowersTest() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        List<UserFollowersDTO> lista = new ArrayList<>();
        FollowersCountDTO followes = new FollowersCountDTO(1, "User 1", lista.size());

        String followersString = writer.writeValueAsString(followes);

        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(followersString);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followers/count",1);

        mockMvc.perform(requestBuilder)
                .andExpectAll(
                        expectedJson,
                        expectedStatus,
                        expectedType);

    }

    @Test
    @DisplayName("TBONUS - Este Test prueba  que se retorna correctamente la lista de seguidores")
    public void getFollowersListSuccess() throws Exception {
        // Arrange
        Integer userId = 2;
        FollowersDTO followers = UserFactory.getFollowersDTOAsc();;

        ObjectWriter writer =  new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        String bodyJson = writer.writeValueAsString(followers);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", userId);

        // Act and Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }

    @Test
    @DisplayName("TBONUS - Este Test prueba la exception cuando un user no es encontrado")
    void countFollowersTestBR() throws Exception {

        Integer userId= 999;

        ObjectWriter writer =  new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        UserNotFoundException error = new UserNotFoundException("Usuario con id "+ userId+ " no encontrado.");
        ErrorDTO errorDTO = new ErrorDTO("Usuario no encontrado",error.getMessage());
        String errorString = writer.writeValueAsString(errorDTO);

        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(errorString);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedJson,
                        expectedStatus,
                        expectedType);

    }

}
