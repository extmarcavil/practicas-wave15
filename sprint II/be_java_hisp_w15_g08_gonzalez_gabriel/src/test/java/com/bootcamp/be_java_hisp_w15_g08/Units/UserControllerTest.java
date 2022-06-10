package com.bootcamp.be_java_hisp_w15_g08.Units;


import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    MockMvc mvc;

    @Test
    public void followUser() throws Exception {
        Integer user_id1 = 1234;

        Integer user_id2 = 1235;

        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", user_id1, user_id2);

        mvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        expextedStatus
                );

    }


    @Test
    public void followersCount() throws Exception {
        Integer user_id1 = 1234;

        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", user_id1);

        mvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        expextedStatus
                );

    }

    @Test
    public void getFollowersList() throws Exception {
        Integer user_id1 = 1234;

        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list", user_id1);

        mvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        expextedStatus
                );

    }

    @Test
    public void getFollowedList() throws Exception {
        Integer user_id1 = 1234;

        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list", user_id1);

        mvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        expextedStatus
                );

    }

    @Test
    public void unFollowUser() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        Integer user_id1 = 1234;

        Integer user_id2 = 1235;



        User user = Util.user1();
        String expectedJson = writer.writeValueAsString(user);

        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isOk();





        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", user_id1, user_id2)
                .contentType(MediaType.APPLICATION_JSON).content(expectedJson);

        mvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expextedStatus)
        ;




    }
}
