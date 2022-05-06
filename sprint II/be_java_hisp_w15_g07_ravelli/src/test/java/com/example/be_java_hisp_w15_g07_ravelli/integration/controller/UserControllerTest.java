package com.example.be_java_hisp_w15_g07_ravelli.integration.controller;

import com.example.be_java_hisp_w15_g07_ravelli.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.UserFollowersDTO;
import com.example.be_java_hisp_w15_g07_ravelli.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    static private ObjectWriter objectMapper;

    @BeforeAll
    static void setUp() {
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @AfterEach
    void doAfter(){
        // Volver a iniciar la base de datos luego de cada tests para no tener datos modificados.
        // Lo ideal seria tener una BD segun tests o produccion, pero por cuestiones de tiempo se adopto esta decision.
        UserRepository.initDatabase();
    }

    @Test
    @DisplayName("TEST INTEGRACION OBLIGATORIO - Post /users/{userId}/follow/{userIdToFollow}:response OK ")
    public void followUserOK() throws Exception {
        //arrange
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 3))
                .andDo(print())
                .andExpectAll(
                        statusOk
                )
                .andReturn();
    }

    @Test
    @DisplayName("TEST INTEGRACION OBLIGATORIO - Post /{userId}/follow/{userIdToFollow}:response NotFound userToFollow")
    public void followUser404() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusNotFound = MockMvcResultMatchers.status().isNotFound();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 103))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusNotFound
                )
                .andReturn();
    }

    @Test
    @DisplayName("TEST INTEGRACION OBLIGATORIO - Post /{userId}/follow/{userIdToFollow}:response BadRequest already followed")
    public void followUser400AlreadyFollowed() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusBadRequest
                )
                .andReturn();
    }

    @Test
    @DisplayName("TEST INTEGRACION OBLIGATORIO - Post /{userId}/follow/{userIdToFollow}:response BadRequest not seller")
    public void followUser400UserNotSeller() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusBadRequest
                )
                .andReturn();
    }

    @Test
    @DisplayName("TEST INTEGRACION OBLIGATORIO - Post /{userId}/follow/{userIdToFollow}:response BadRequest follow yourself")
    public void followUser400FollowYourself() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 2))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusBadRequest
                )
                .andReturn();
    }

    //BONUS

    @Test
    @DisplayName("GET /users/{userId}/followers/count - response OK")
    public void countFollowersOK() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();
        FollowersCountDTO followersCountDTO = new FollowersCountDTO(2, "User 2", 2);
        ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(followersCountDTO));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk,
                        content
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followers/count - response 404")
    public void countFollowers404() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusNotFound = MockMvcResultMatchers.status().isNotFound();
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", 100))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusNotFound
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followers/count - response 400 - negative id")
    public void countFollowersNegativeId() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", -2))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusBadRequest
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followers/list - response OK")
    void getFollowersListOK() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        UserFollowersDTO userFollowersDTO1 = new UserFollowersDTO(1, "User 1");
        UserFollowersDTO userFollowersDTO3 = new UserFollowersDTO(3, "User 3");
        FollowersDTO followersDTO = new FollowersDTO(2, "User 2", List.of(userFollowersDTO1, userFollowersDTO3));
        ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(followersDTO));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk,
                        content
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followers/list - ordered ascendant - response OK")
    void getFollowersListOrderedAsc() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        UserFollowersDTO userFollowersDTO1 = new UserFollowersDTO(1, "User 1");
        UserFollowersDTO userFollowersDTO3 = new UserFollowersDTO(3, "User 3");
        FollowersDTO followersDTO = new FollowersDTO(2, "User 2", List.of(userFollowersDTO1, userFollowersDTO3));
        ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(followersDTO));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "name_asc");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2)
                        .params(params))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk,
                        content
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followers/list - ordered descendant - response OK")
    void getFollowersListOrderedDesc() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        UserFollowersDTO userFollowersDTO1 = new UserFollowersDTO(1, "User 1");
        UserFollowersDTO userFollowersDTO3 = new UserFollowersDTO(3, "User 3");
        FollowersDTO followersDTO = new FollowersDTO(2, "User 2", List.of(userFollowersDTO3, userFollowersDTO1));
        ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(followersDTO));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "name_desc");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2)
                        .params(params))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk,
                        content
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followers/list - response 400 - invalid param")
    void getFollowersListOrderBadRequest() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "error");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2)
                        .params(params))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusBadRequest
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followers/list - response 404")
    void getFollowersNotFound() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusNotFound = MockMvcResultMatchers.status().isNotFound();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/list", 100))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusNotFound
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followed/list - response OK")
    void getFollowedListOK() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        UserFollowersDTO userFollowersDTO2 = new UserFollowersDTO(2, "User 2");
        UserFollowersDTO userFollowersDTO3 = new UserFollowersDTO(3, "User 3");
        FollowedDTO followedDTO = new FollowedDTO(1, "User 1", List.of(userFollowersDTO2, userFollowersDTO3));
        ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(followedDTO));

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk,
                        content
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followed/list - ordered ascendant - response OK")
    void getFollowedListOrderedAsc() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        UserFollowersDTO userFollowersDTO2 = new UserFollowersDTO(2, "User 2");
        UserFollowersDTO userFollowersDTO3 = new UserFollowersDTO(3, "User 3");
        FollowedDTO followedDTO = new FollowedDTO(1, "User 1", List.of(userFollowersDTO2, userFollowersDTO3));
        ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(followedDTO));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "name_asc");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .params(params))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk,
                        content
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followed/list - ordered descendant - response OK")
    void getFollowedListOrderedDesc() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        UserFollowersDTO userFollowersDTO2 = new UserFollowersDTO(2, "User 2");
        UserFollowersDTO userFollowersDTO3 = new UserFollowersDTO(3, "User 3");
        FollowedDTO followedDTO = new FollowedDTO(1, "User 1", List.of(userFollowersDTO3, userFollowersDTO2));
        ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(followedDTO));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "name_desc");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .params(params))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk,
                        content
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followed/list invalid param - response 400 - invalid argument 'order'")
    void getFollowedListOrderBadRequest() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "error");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .params(params))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusBadRequest
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /users/{userId}/followed/list - response OK")
    void getFollowedNotFound() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusNotFound = MockMvcResultMatchers.status().isNotFound();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followed/list", 100))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusNotFound
                )
                .andReturn();
    }

    @Test
    @DisplayName("POST /users/{userId}/unfollow/{userIdToUnfollow} - response OK")
    void unfollowUserOK() throws Exception {
        //arrange
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print())
                .andExpectAll(
                        statusOk
                )
                .andReturn();
    }

    @Test
    @DisplayName("POST /users/{userId}/unfollow/{userIdToUnfollow} - response 404")
    void unfollowUserNotFoundUserId() throws Exception {
        //arrange
        ResultMatcher statusNotFound = MockMvcResultMatchers.status().isNotFound();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 100, 2))
                .andDo(print())
                .andExpectAll(
                        statusNotFound
                )
                .andReturn();
    }

    @Test
    @DisplayName("POST /users/{userId}/unfollow/{userIdToUnfollow} - response 400 - not following")
    void unfollowUserNotFollowing() throws Exception {
        //arrange
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 1))
                .andDo(print())
                .andExpectAll(
                        statusBadRequest
                )
                .andReturn();
    }

    @Test
    @DisplayName("POST /users/{userId}/unfollow/{userIdToUnfollow} - response 400 - same userId and userIdToUnfollow")
    void unfollowYourself() throws Exception {
        //arrange
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 2))
                .andDo(print())
                .andExpectAll(
                        statusBadRequest
                )
                .andReturn();
    }
}