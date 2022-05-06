package com.bootcamp.be_java_hisp_w15_g02.integration_test;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.ErrorDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    private String url;

    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer;

    @BeforeEach
    void setup() {
        url = "/users";
        this.writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("Un usuario empieza a seguir a otro usuario")
    void userFollowUserSuccess() throws Exception {
        // arrange
        int validUserId = 4;
        int validUserToFollowId = 5;
        String message = "Seguidor anadido";

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedString = MockMvcResultMatchers.content().string(message);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.valueOf("text/plain;charset=UTF-8"));

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                                                    .post(url+"/{userId}/follow/{userIdToFollow}",
                                                            validUserId, validUserToFollowId)
                                                    .contentType(MediaType.TEXT_PLAIN_VALUE);

        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedString, expectedContentType);
    }

    @Test
    @DisplayName("Un usuario intenta seguirse a si mismo")
    void userFollowHimself() throws Exception {
        // arrange
        int validUserId = 1;
        int validUserToFollowId = 1;
        ErrorDTO errorMessage = new ErrorDTO(HttpStatus.BAD_REQUEST.toString(), "No puede seguirse así mismo.");
        String jsonExpected = writer.writeValueAsString(errorMessage);

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedString = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url+"/{userId}/follow/{userIdToFollow}",
                        validUserId, validUserToFollowId);

        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedString, expectedContentType);
    }

    @Test
    @DisplayName("Un usuario intenta seguir a un usuario que ya sigue.")
    void userFollowUserAlreadyFollows() throws Exception {
        // arrange
        int validUserId = 1;
        int validUserToFollowId = 4;
        ErrorDTO errorMessage = new ErrorDTO(HttpStatus.BAD_REQUEST.toString(), "Ya sigue a este usuario.");
        String jsonExpected = writer.writeValueAsString(errorMessage);

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedString = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url+"/{userId}/follow/{userIdToFollow}",
                        validUserId, validUserToFollowId);

        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedString, expectedContentType);
    }

    @Test
    @DisplayName("Un usuario intenta dejar de seguir a otro usuario que no sigue")
    void userUnfollowUserFail() throws Exception {
        // arrange
        int validUserId = 2;
        int invalidUserToUnfollowId = 4;
        ErrorDTO errorMessage = new ErrorDTO(HttpStatus.BAD_REQUEST.toString(),
                                    "No sigues al usuario que intentas dejar de seguir");
        String jsonExpected = writer.writeValueAsString(errorMessage);

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedString = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url+"/{userId}/unfollow/{userIdToFollow}",
                        validUserId, invalidUserToUnfollowId);

        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedString, expectedContentType);
    }

    @Test
    @DisplayName("Un usuario deja de seguir a otro usuario")
    void userUnfollowUserSuccess() throws Exception {
        // arrange
        int validUserId = 1;
        int validUserToUnfollowId = 5;
        String message = "Dejo de seguir al usuario: " + validUserToUnfollowId;

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedString = MockMvcResultMatchers.content().string(message);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.valueOf("text/plain;charset=UTF-8"));

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url+"/{userId}/unfollow/{userIdToFollow}",
                        validUserId, validUserToUnfollowId)
                .contentType(MediaType.TEXT_PLAIN_VALUE);

        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedString, expectedContentType);
    }

    @Test
    @DisplayName("Obtener la cantidad de seguidores de un usuario")
    void getFollowersCount() throws Exception {
        // arrange
        int validUserId = 5;
        GetFollowersCountDTO followersCountDTO = new GetFollowersCountDTO(validUserId, "Ramiro", 3);
        String jsonExpected = writer.writeValueAsString(followersCountDTO);

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url+"/{userId}/followers/count", validUserId);
        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }
}
