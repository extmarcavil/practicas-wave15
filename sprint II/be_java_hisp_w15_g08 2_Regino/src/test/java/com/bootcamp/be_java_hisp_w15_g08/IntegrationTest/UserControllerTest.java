package com.bootcamp.be_java_hisp_w15_g08.IntegrationTest;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.util.Utils2;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//        ObjectWriter writer = new ObjectMapper()
//                .writer();
        //Arrange
        Integer id1 = 1234;
//        FollowersCountDTO followersCountDTO = Utils2.followersCountDTO1();
//        ResponseEntity<FollowersCountDTO> expected = new ResponseEntity<>(followersCountDTO, HttpStatus.ACCEPTED);
//        String responseJson = writer.writeValueAsString(expected);


        //Expected
      //  ResultMatcher expecteJson = MockMvcResultMatchers.content().json(responseJson);
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/users/{userId}/followers/count",id1);

        //Act y Assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
//                        , expecteJson
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
