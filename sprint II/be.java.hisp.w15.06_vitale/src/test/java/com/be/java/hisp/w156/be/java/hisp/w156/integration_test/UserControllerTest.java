package com.be.java.hisp.w156.be.java.hisp.w156.integration_test;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.ProductDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserCountFollowersDTO;
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
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Verificar la correcta obtención de la cantidad de seguidores.")
    void whenGetCountFollowersThenReturnsOk() throws Exception {
        // Arrange

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        Integer userId = 3;
        UserCountFollowersDTO userCountFollowersDTO = new UserCountFollowersDTO(userId, "Dardo", 2);

        String expectedBody = writer.writeValueAsString(userCountFollowersDTO);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);

        // Act & Assert
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