package com.bootcamp.be_java_hisp_w15_g08.Integration;
import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.UserRepository;
import com.bootcamp.be_java_hisp_w15_g08.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    static UserRepository repository = new UserRepository();


    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Request de Followers Count")
    public void followersCount() throws Exception{


        ObjectWriter writer =  new ObjectMapper()
                .writer();

        FollowersCountDTO expectedDto = new FollowersCountDTO();
        expectedDto.setUser_id(1250);
        expectedDto.setUser_name("Fulanito Opitz");
        expectedDto.setFollowers_count(2);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/1234/follow/1250");
        MockHttpServletRequestBuilder request2 = MockMvcRequestBuilders.post("/users/1235/follow/1250");




        String expectedResponse = writer.writeValueAsString(expectedDto);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isAccepted();


        MockHttpServletRequestBuilder request3 = MockMvcRequestBuilders.get("/users/1250/followers/count");

        mvc.perform(request);
        mvc.perform(request2);

        ResultActions result = mvc
                .perform(request3)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(MockMvcResultMatchers.content().json(expectedResponse));



    }
}