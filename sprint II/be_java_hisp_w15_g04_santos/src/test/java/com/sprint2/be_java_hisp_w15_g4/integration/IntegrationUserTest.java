package com.sprint2.be_java_hisp_w15_g4.integration;

import com.sprint2.be_java_hisp_w15_g4.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationUserTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        new UserRepository();
    }


    @Test
    @DisplayName("Follow User")
    void followUserSucess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Unfollow User")
    void unfollowUserSucess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Count user followers")
    void countUserFollowersSucess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.followers_count").value(0));
    }

    @Test
    @DisplayName("Count user followers")
    void getUserFollowersSucess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.followers.length()").value(0));
    }

    @Test
    @DisplayName("Count user followers")
    void getUserFollowedSucess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.followed.length()").value(0));
    }

    @Test
    @DisplayName("User doesn't exist Exception")
    void userIdException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 7, 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.mensaje").value("No se ha encontrado el usuario: 7"));
    }

    @Test
    @DisplayName("Follow User Exception")
    void followUserException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isConflict())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.mensaje").value("Los id deben ser diferentes: 1"));
    }

    @Test
    @DisplayName("Bad Argument Exception")
    void badArgumentException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1)
                .param("order", "name_as"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.mensaje").value("El parametro de ordemiento es incorrecto: name_as"));
    }

}
