package com.bootcamp.be_java_hisp_w15_g08.IntegrationTest;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void followUser() throws Exception {
        //Arrange
        Integer id1 = 1234;
        Integer id2 = 1235;

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",id2,id1);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
    }

    @Test
    public void followersCount() throws Exception {
        //Arrange
        Integer id1 = 1234;

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();
        ResultMatcher expectedJson = content().contentType("application/json");
        ResultMatcher expectedValue = jsonPath("$.followers_count").value(2);

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/users/{userId}/followers/count",id1);
        System.out.println(req.toString());

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                        , expectedValue
                        , expectedJson
                );
    }

    @Test
    public void getFollowersList() throws Exception {
        //Arrange
        Integer id1 = 1234;

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/users/{userId}/followers/list",id1);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
    }

    @Test
    public void getFollowedList() throws Exception {
        //Arrange
        Integer id1 = 1234;

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/users/{userId}/followed/list",id1);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
    }

    @Test
    public void unFollowUser() throws Exception {
        //Arrange
        Integer id1 = 1234;
        Integer id2 = 1235;

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",id2,id1);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
    }

}
