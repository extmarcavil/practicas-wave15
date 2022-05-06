package com.bootcamp.be_java_hisp_w15_g02.integration.controllers;

import com.bootcamp.be_java_hisp_w15_g02.integration.utils.GlobalIntegration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc _mockMvc;

    @Test
    @DisplayName("valid correct follow")
    void validFollow() throws Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,6)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                                MockMvcResultMatchers.status().isOk(),
                                MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"),
                                MockMvcResultMatchers.content().string("Seguidor anadido")
                        );
    }

    @Test
    @DisplayName("invalid follow")
    void invalidFollow() throws Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.jsonPath("$.message").value("No puede seguirse así mismo.")
                );
    }

    @Test
    @DisplayName("valid correct count follows")
    void validCountFollows() throws Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.followersCount").value(GlobalIntegration.getFollowersCountDummy().getFollowersCount())
                );
    }

    @Test
    @DisplayName("valid list follows by seller user")
    void listFollowsBySellerUser() throws Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.followers.length()")
                                .value(GlobalIntegration.listFollowersBySellerDummy().size())
                );
    }

    @Test
    @DisplayName("valid list follows by user")
    void listFollowedByUser() throws Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.followed.length()")
                                .value(GlobalIntegration.listFollowedUserDummy().size())
                );
    }

    @Test
    @DisplayName("valid unfollow")
    void validUnfollow() throws Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnFollow}",2,4)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"),
                        MockMvcResultMatchers.content().string("Dejo de seguir al user: 4")
                );
    }

    @Test
    @DisplayName("invalid unfollow")
    void invalidUnfollow() throws Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnFollow}",100,4)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isNotFound(),
                        MockMvcResultMatchers.jsonPath("$.message").value("El usuario no existe.")
                );
    }
}
