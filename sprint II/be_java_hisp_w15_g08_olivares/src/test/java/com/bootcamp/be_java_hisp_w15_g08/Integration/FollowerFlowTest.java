package com.bootcamp.be_java_hisp_w15_g08.Integration;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@SpringBootTest
@AutoConfigureMockMvc
public class FollowerFlowTest {
    @Autowired
    MockMvc mockMvc;
    private int followersCount;
    private int contentSize;

    //calls followers count and fills the followers count and content size variables
    @Test
    public void followersFlow1() throws Exception {
        int userId = 1234;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isAccepted();
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId);
        ResultActions result = mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
        contentSize = result.andReturn().getResponse().getContentAsString().length();
        char responseChar = result.andReturn().getResponse().getContentAsString().charAt(contentSize-2);
        followersCount= Character.getNumericValue(responseChar);
    }

    //follows an user
    @Test
    public void followersFlow2() throws Exception {
        int userToFollowId = 1234;
        int userId = 1235;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userId,userToFollowId);
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    //validates the previous method by checking if the value of the followers count on the user "1234" is now 1
    @Test
    public void followersFlow3() throws Exception {
        int userId = 1234;
        ResultMatcher expectedStatus = MockMvcResultMatchers.jsonPath("$.followers_count").value("1");
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId);
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    //unfollows an user
    @Test
    public void followersFlow4() throws Exception {
        int userToFollowId = 1234;
        int userId = 1235;
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",userId,userToFollowId);
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    //validates the previous method by checking the followers count to be equal to 0
    @Test
    public void followersFlow5() throws Exception {
        int userId = 1234;
        ResultMatcher expectedStatus = MockMvcResultMatchers.jsonPath("$.followers_count").value("0");
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId);
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }
}