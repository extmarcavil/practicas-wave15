package com.example.be_java_hisp_w15_g05.integration_test;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
public class FollowerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName(" Integracion - Un usuario sigue a otro.")
    void followTest() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 12, 1);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // act & assert
        mockMvc.perform(request)
                .andExpect(expectedStatus);
    }
    @Test
    @DisplayName(" Excepcion de usuario ya siguiendo al usuario a seguir.")
    void alreadyFollowingException() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 10, 1);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // act & assert
        mockMvc.perform(request)
                .andExpect(expectedStatus);
    }
    @Test
    @DisplayName(" Excepcion de usuario a seguir no es vendedor.")
    void notVendorFollowingException() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 12, 1);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // act & assert
        mockMvc.perform(request)
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Integracion - Dejar de seguir un usuario.")
    void unfollowTest() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToFollow}", 12, 1);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(expectedStatus);
    }
    @Test
    @DisplayName("Excepcion el usuario no seguia al vendedor.")
    void notFollowingException() throws Exception {
        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToFollow}", 12, 2);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // act & assert
        mockMvc.perform(request)
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Integracion cantidad de seguidores.")
    void countFollowers() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        ResCountFollowersDTO response = new ResCountFollowersDTO(2, "Antonio", 1);

        String json = writer.writeValueAsString(response);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(json);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }
}
