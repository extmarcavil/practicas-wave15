package com.sprint1.be_java_hisp_w15_g03.integration;

import com.sprint1.be_java_hisp_w15_g03.exception.RelationConflictException;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    //Inicializacion de repositorio de pruebas
    static IMeliRepository meliRepository = new MeliRepository();


    //Seteo del repositorio con los datos necesarios para los tests
    @BeforeAll
    public static void setUpWriter() {
        //Seteo de user.userId=1 sigue a seller.userId=1
        meliRepository.followSeller(1, 1);
    }

    @AfterAll
    public static void borrowSetUp() {
        meliRepository.unFollowSeller(1, 1);
    }

    @Test
    @DisplayName("Verifica que la integracion para que un user siga a un seller sea correcta")
    public void testValidFollowSeller() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verifica que la integracion para que un user no pueda seguir a un seller que ya sigue devuelva el mensaje correcto")
    public void testInvalidFollowSeller() throws Exception {

        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertTrue(result.getResolvedException() instanceof RelationConflictException);
    }

    @Test
    @DisplayName("Verifica que la integracion para obtener la cantidad de seguidores de un usario sea correcta")
    public void testValidGetFollowersCount() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.followersCount").value(1));
    }

    @Test
    @DisplayName("Verifica que la integracion para obtener la lista de seguidores de un seller sea correcta")
    public void testValidGetFollowersList() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.followers.size()").value(1));
    }

    @Test
    @DisplayName("Verificar que la integracion para obtener la lista de sellers seguidos por un user sea correcta")
    public void testValidGetFollowedList() throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.followed.size()").value(1));
    }

    @Test
    @DisplayName("Verificar que la integracion para dejar de seguir un seller sea correcta")
    public void testValidUnFollowSeller() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verificar que la integracion para no permitir dejar de seguir un seller no seguido sea correcta")
    public void testInvalidUnFollowSeller() throws Exception {
        MvcResult result = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertTrue(result.getResolvedException() instanceof RelationConflictException);
    }
}
