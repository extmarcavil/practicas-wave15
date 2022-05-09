package com.example.be_java_hisp_w15_g05.integration;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

@SpringBootTest
@AutoConfigureMockMvc
public class FollowsControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void followersCountOk() throws Exception{
        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .writer();

        ResCountFollowersDTO resCountFollowersDTO = new ResCountFollowersDTO(1,"Marcos Galperin",2);
        String resJson = writer.writeValueAsString(resCountFollowersDTO);

        //Expected
        // EXPECTED
        ResultMatcher expecteJson = MockMvcResultMatchers.content().json(resJson);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders.get("/users/{userId}/followers/count",1);

        //act & assert
        mockMvc
                .perform(req)
                .andExpectAll(expectedStatus,expecteJson);
    }

    @Test
    void cantFollowHimselft() throws Exception{
        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .writer();

        ResCountFollowersDTO resCountFollowersDTO = new ResCountFollowersDTO(1,"Marcos Galperin",2);
        String resJson = writer.writeValueAsString(resCountFollowersDTO);

        //Expected
        // EXPECTED
        ResultMatcher expecteMsg = MockMvcResultMatchers.content().string("Un usuario no se puede seguir a sí mismo");
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,1);

        //act & assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus,expecteMsg);
    }
}
