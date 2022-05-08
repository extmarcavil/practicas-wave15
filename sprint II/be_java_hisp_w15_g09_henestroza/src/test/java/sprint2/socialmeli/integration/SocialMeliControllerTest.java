package sprint2.socialmeli.integration;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sprint2.socialmeli.exceptions.InvalidFollower;

import java.util.List;
import java.util.Objects;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test user follows itself throws InvalidFollower Exception")
    public void testFollowSameUser() throws Exception {
        // Arrange
        ResultMatcher badRequestStatus = MockMvcResultMatchers.status().isBadRequest();
        // Act
        MockHttpServletRequestBuilder followRequest = MockMvcRequestBuilders.post("/users/{followerId}/follow/{followedId}", "1", "1");
        // Assert
        mockMvc.perform(followRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        result -> {
                            Assertions.assertEquals(InvalidFollower.class,
                                    Objects.requireNonNull(result.getResolvedException()).getClass());
                        },
                        badRequestStatus
                );
    }

    @Test
    @DisplayName("Test user unfollows itself throws InvalidFollower Exception")
    public void testUnfollowSameUser() throws Exception {
        // Arrange
        ResultMatcher badRequestStatus = MockMvcResultMatchers.status().isBadRequest();
        // Act
        MockHttpServletRequestBuilder unfollowRequest = MockMvcRequestBuilders.post("/users/{followerId}/unfollow/{followedId}", "1", "1");
        // Assert
        mockMvc.perform(unfollowRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        result -> {
                            Assertions.assertEquals(InvalidFollower.class,
                                    Objects.requireNonNull(result.getResolvedException()).getClass());
                        },
                        badRequestStatus
                );
    }

    @Test
    @DisplayName("Test unfollow responds with 200 OK")
    public void testUnfollow() throws Exception {
        // Arrange
        Integer followerId = 1;
        Integer followedId = 5;
        ResultMatcher okStatus = MockMvcResultMatchers.status().isOk();
        String expectedResponse = "El usuario: "+ followerId + " dejo de seguir a "+ followedId;
        // Act
        MockHttpServletRequestBuilder followRequest = MockMvcRequestBuilders.post("/users/{followerId}/follow/{followedId}", followerId, followedId);
        MockHttpServletRequestBuilder unfollowRequest = MockMvcRequestBuilders.post("/users/{followerId}/unfollow/{followedId}", followerId, followedId);
        // Assert
        performOkRequest(followRequest);
        mockMvc.perform(unfollowRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        okStatus,
                        result -> {
                            Assertions.assertEquals(expectedResponse, result.getResponse().getContentAsString());
                        }
                );
    }

    @Test
    @DisplayName("Test user follower count")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testFollowerCount() throws Exception {
        // Arrange
        Integer followerId = 4;
        Integer followedId = 6;
        ResultMatcher okStatus = MockMvcResultMatchers.status().isOk();
        Integer expectedResponse = 1;
        // Act
        MockHttpServletRequestBuilder followRequest = MockMvcRequestBuilders.post("/users/{followerId}/follow/{followedId}", followerId, followedId);
        MockHttpServletRequestBuilder followerCountRequest = MockMvcRequestBuilders.get("/users/{userId}/followers/count", followedId);
        // Assert
        performOkRequest(followRequest);
        mockMvc.perform(followerCountRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        okStatus,
                        MockMvcResultMatchers.jsonPath("$.followers_count").value(expectedResponse)
                );
    }

    @Test
    @DisplayName("Test user follower list")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testFollowerList() throws Exception {
        // Arrange
        ResultMatcher okStatus = MockMvcResultMatchers.status().isOk();
        Integer expectedFollowerCount = 2;
        // Act
        MockHttpServletRequestBuilder followRequest1 = MockMvcRequestBuilders.post("/users/{followerId}/follow/{followedId}", "1", "2");
        MockHttpServletRequestBuilder followRequest2 = MockMvcRequestBuilders.post("/users/{followerId}/follow/{followedId}", "3", "2");
        MockHttpServletRequestBuilder followerListRequest = MockMvcRequestBuilders.get("/users/{userId}/followers/list", "2");
        // Assert
        performOkRequest(followRequest1);
        performOkRequest(followRequest2);
        mockMvc.perform(followerListRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.jsonPath("$.followers.size()").value(expectedFollowerCount),
                        okStatus
                );
    }

    @Test
    @DisplayName("Test user followed list")
    public void testFollowedList() throws Exception {
        // Arrange
        ResultMatcher okStatus = MockMvcResultMatchers.status().isOk();
        Integer expectedFollowerCount = 3;
        // Act
        MockHttpServletRequestBuilder followRequest1 = MockMvcRequestBuilders.post("/users/{followerId}/follow/{followedId}", "1", "2");
        MockHttpServletRequestBuilder followRequest2 = MockMvcRequestBuilders.post("/users/{followerId}/follow/{followedId}", "1", "3");
        MockHttpServletRequestBuilder followRequest3 = MockMvcRequestBuilders.post("/users/{followerId}/follow/{followedId}", "1", "4");
        MockHttpServletRequestBuilder followedListRequest = MockMvcRequestBuilders.get("/users/{userId}/followed/list", "1");
        // Assert
        performOkRequest(followRequest1);
        performOkRequest(followRequest2);
        performOkRequest(followRequest3);
        mockMvc.perform(followedListRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.jsonPath("$.followed.size()").value(expectedFollowerCount),
                        okStatus
                );
    }

    private void performOkRequest(MockHttpServletRequestBuilder request) throws Exception {
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
