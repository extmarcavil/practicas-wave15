package com.sprint1.be_java_hisp_w15_g4.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g4.dto.UserDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import org.junit.jupiter.api.DisplayName;
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
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Verifica que se estan cotando los seguidores del usuario correcto")
    void countFollowersOk() throws Exception {
        ObjectWriter writer =  new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        //Arrange
        int id_User=1;
        FollowerCountDTO dto = new FollowerCountDTO(1,"nombre1",0);
        String userJson = writer.writeValueAsString(dto);

        //Expected
        ResultMatcher expetedStatus= MockMvcResultMatchers.status().isOk();
        ResultMatcher expetedJson= MockMvcResultMatchers.content().json(userJson);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{user_id}/followers/count",id_User);

        //Act & Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expetedJson,expetedStatus);

    }

}
