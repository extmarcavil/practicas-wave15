package com.be.java.hisp.w156.be.java.hisp.w156.controller;


import com.be.java.hisp.w156.be.java.hisp.w156.repository.UserRepositoryImpl;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    IUserService service;

    @InjectMocks
    UserController controller;

    @BeforeEach
    public void initDataTest(){
        new UserRepositoryImpl();
    }

    @Test
    @DisplayName("Corroborar que un usuario pueda seguir a otro correctamente")
    void followUserOK() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 4,3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Corroborar que un usuario no pueda seguir a un usuario que ya sigue")
    void followUserNoOK() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1,3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Corroborar que un usuario pueda dejar de seguir a otro usuario de forma correctamente")
    void unfollowUserOK() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 1, 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Corroborar que un usuario no pueda dejar de seguir a un usuario que no sigue")
    void unfollowUserNoOK() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 4, 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Lista de personas que siguen al usuario")
    void listFolowersAtUser() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Erros al pedirLista de personas que siguen a un usuario incorrecto")
    void listFolowersAtUserIncorrect() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 5))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Lista de personas a las que sigue un determinado usuario existente")
    void listFolowedUser() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Erros al pedir la lista de personas a las que sigue un determinado usuario incorrecto")
    void listFolowedUserIncorrect() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 5))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Cantidad de seguidores para un usuario existente")
    void countFolowedUser() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }

    @Test
    @DisplayName("Cantidad de seguidores para un usuario inexistente")
    void countFolowedUserIncorrect() throws Exception {
        ResultMatcher expetedStatus = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 5))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);
    }
}