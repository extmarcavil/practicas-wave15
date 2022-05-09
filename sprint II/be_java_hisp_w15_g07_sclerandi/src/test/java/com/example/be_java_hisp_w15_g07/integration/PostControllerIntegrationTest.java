package com.example.be_java_hisp_w15_g07.integration;

import com.example.be_java_hisp_w15_g07.dto.response.ErrorDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.utils.InitDatabase;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    @BeforeEach
    void setup(){
        this.writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("BONUS - Verificar que se obtiene correctamente la lista de posts")
    public void getUserFollowedPostsSuccess() throws Exception {
        // Arrange
        Integer userId = 1;
        UserFollowedPostsDTO followedPosts = UserFactory.getUserOneFollowedDTO();
        String bodyJson = writer.writeValueAsString(followedPosts);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", userId);

        // Act and Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }

    @Test
    @DisplayName("BONUS - Verificar que se laza una excepción cuando el tipo de ordenamiento no es válido")
    public void getUserFollowedPostsOrderBadRequest() throws Exception {
        // Arrange
        Integer userId = 1;
        ErrorDTO error = new ErrorDTO("Peticion invalida", "Argumento de ordenamiento invalido");
        String bodyJson = writer.writeValueAsString(error);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isBadRequest();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", userId)
                .param("order", "Cualquier ordenamiento");

        // Act and Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }
}
