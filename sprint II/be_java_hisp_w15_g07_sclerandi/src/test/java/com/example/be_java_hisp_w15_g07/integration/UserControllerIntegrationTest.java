package com.example.be_java_hisp_w15_g07.integration;

import com.example.be_java_hisp_w15_g07.dto.response.ErrorDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

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
    @DisplayName("INDIVIDUAL - Verificar que la cantidad de seguidores de un determinado usuario sea correcta")
    public void countFollowersSuccess() throws Exception {
        // Arrange
        Integer userId = 2;
        FollowersCountDTO followersCount = new FollowersCountDTO(userId, "User 2", 2);

        String bodyJson = writer.writeValueAsString(followersCount);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", userId);

        // Act and Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }

    @Test
    @DisplayName("BONUS - Verificar que se lanza una excepción cuando el usuario no existe")
    public void countFollowersUserNotFound() throws Exception {
        // Arrange
        Integer userId = 100;
        ErrorDTO error = new ErrorDTO("Usuario no encontrado", "Usuario con id 100 no encontrado.");
        String bodyJson = writer.writeValueAsString(error);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isNotFound();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", userId);

        // Act and Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }

    @Test
    @DisplayName("BONUS - Verificar que se retorna correctamente la lista de seguidores")
    public void getFollowersListSuccess() throws Exception {
        // Arrange
        Integer userId = 2;
        FollowersDTO followers = UserFactory.getFollowersDTOAsc();;

        String bodyJson = writer.writeValueAsString(followers);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", userId);

        // Act and Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }

    @Test
    @DisplayName("BONUS - Verificar que se retorna correctamente la lista de seguidos")
    public void getFollowedListSuccess() throws Exception {
        // Arrange
        Integer userId = 1;
        FollowedDTO followed = UserFactory.getFollowedDTOAsc();;

        String bodyJson = writer.writeValueAsString(followed);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", userId);

        // Act and Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }

    @Test
    @DisplayName("BONUS - Verificar que se retorna correctamente la lista de seguidores con ordenamiento descendente")
    public void getFollowersListDescSuccess() throws Exception {
        // Arrange
        Integer userId = 2;
        FollowersDTO followers = UserFactory.getFollowersDTODesc();;

        String bodyJson = writer.writeValueAsString(followers);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", userId)
                .param("order", "name_desc");

        // Act and Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }

    @Test
    @DisplayName("BONUS - Verificar que se retorna correctamente la lista de seguidos con ordenamiento descendente")
    public void getFollowedListDescSuccess() throws Exception {
        // Arrange
        Integer userId = 1;
        FollowedDTO followed = UserFactory.getFollowedDTODesc();;

        String bodyJson = writer.writeValueAsString(followed);

        // Expected
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(bodyJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatusCode = MockMvcResultMatchers.status().isOk();

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", userId)
                .param("order", "name_desc");

        // Act and Assert
        mockMvc
                .perform(request)
                .andDo(print())
                .andExpectAll(expectedJson, expectedContentType, expectedStatusCode);
    }
}
