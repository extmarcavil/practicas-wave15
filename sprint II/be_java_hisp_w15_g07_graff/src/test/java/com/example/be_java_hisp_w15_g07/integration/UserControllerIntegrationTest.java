package com.example.be_java_hisp_w15_g07.integration;

import com.example.be_java_hisp_w15_g07.dto.response.ErrorDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowersDTO;
import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
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
    @DisplayName("Este Test prueba el retorno de la cuenta de seguiores")
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
    @DisplayName("Este Test prueba el envio ")
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

    @Test
    @DisplayName("Este Test prueba el envio ")
    void countFollowersTestNF() throws Exception {
        //UserNotFoundException error = new UserNotFoundException("El id de usuario no es valido");


        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}/followers/count",999);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        expectedStatus);

    }
}
