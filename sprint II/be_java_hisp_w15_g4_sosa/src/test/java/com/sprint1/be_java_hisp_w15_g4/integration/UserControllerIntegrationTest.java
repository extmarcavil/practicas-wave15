package com.sprint1.be_java_hisp_w15_g4.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.IdNotPositiveErrorDTO;
import com.sprint1.be_java_hisp_w15_g4.exception.IDNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Probamos el follow con usuarios validos")
    void followSuccess() throws Exception {

        // arrange

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post(
                        "/users/{userId}/follow/{userIdToFollow}", 1,2);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Probamos el follow con id de usuarios incorrectos")
    void followFailed() throws Exception {

        // arrange

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // REQUEST
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post(
                        "/users/{userId}/follow/{userIdToFollow}", 0,0);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Probamos el follow con id de usuarios incorrectos para verificar si arroja excepciones")
    void followFailedException() throws Exception {

        // arrange
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        Map<String, String> errors = new HashMap<>();
        errors.put("userId","El id debe ser mayor a cero.");
        errors.put("userIdToFollow","El id debe ser mayor a cero.");
        String listJson = writer.writeValueAsString(
                new IdNotPositiveErrorDTO(HttpStatus.BAD_REQUEST, errors)
        );

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        // REQUEST
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post(
                        "/users/{userId}/follow/{userIdToFollow}", -1,-1);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedJson
                );
    }

    @Test
    @DisplayName("Probamos el metodo que retorna la cantidad de seguidores")
    void countFollowSuccess() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange
        FollowerCountDTO followerCountDTOResponseEntity=
                new FollowerCountDTO(1,"nombre1",0);
        String followerJson = writer.writeValueAsString(followerCountDTOResponseEntity);
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(followerJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        // REQUEST
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get(
                        "/users/{userId}/followers/count", 1);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedJson
                );
    }

    @Test
    @DisplayName("Probamos el metodo que retorna la cantidad de seguidores pasandole parametros invalidos")
    void countFollowFailed() throws Exception {

        // arrange
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        // REQUEST
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get(
                        "/users/{userId}/followers/count", -1);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }
}
