package com.example.be_java_hisp_w15_g05.integration;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListSellersDTO;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import com.example.be_java_hisp_w15_g05.repository.UserRepository;
import com.example.be_java_hisp_w15_g05.service.FollowsService;
import com.example.be_java_hisp_w15_g05.utils.UsersFactory;
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
public class FollowsControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static IUserRepository repository = new UserRepository();
    static FollowsService service = new FollowsService(repository);

    @Test
    public void followTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 12, 1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void userAlreadyFollowedTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 10, 1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void cannotFollowHimselfTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 1, 1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void userNotSellerTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 1, 12);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void unfollowTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToFollow}", 12, 1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void userNotFollowingTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToFollow}", 12, 1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void countFollowersTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        ResCountFollowersDTO response = new ResCountFollowersDTO(2, "Antonio", 1);

        String json = writer.writeValueAsString(response);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(json);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    public void getListFollowersTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        ResListFollowersDTO response = UsersFactory.getListFollowers();

        String json = writer.writeValueAsString(response);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(json);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    public void getListFollowedTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        ResListSellersDTO response = UsersFactory.getListFollowed();

        String json = writer.writeValueAsString(response);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(json);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }
}
