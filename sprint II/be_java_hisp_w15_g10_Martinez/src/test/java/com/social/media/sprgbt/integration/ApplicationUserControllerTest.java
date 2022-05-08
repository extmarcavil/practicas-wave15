package com.social.media.sprgbt.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.media.sprgbt.dto.UserDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationUserControllerTest {

    @Autowired
    private MockMvc mvc;

    ObjectMapper objectMapper;

    /**
     * Method BeforeEach() del ciclo de vida
     * Para Inicializar el ObjectMapper
     */
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    /**
     * Tests Integration*
     */

    @Test
    @Order(1)
    @DisplayName("Create User.")
    void createUserTest() throws Exception {

        mvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new UserDto(null, "Juan", 3, List.of(), List.of()))))

                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userName").value("Juan"));


    }

    @Test
    @Order(2)
    @DisplayName("Create User2.")
    void createUser2Test() throws Exception {

        mvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new UserDto(null, "Pedro", 3, List.of(), List.of()))))

                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userName").value("Pedro"));


    }

    @Test
    @Order(3)
    @DisplayName("Follow A Seller In existing.")
    void followASellerinExistingTest() throws Exception {

        MvcResult response = mvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 3)
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals("El Usuario con userId: 3 no existe en la BD.", response.getResponse().getContentAsString());
    }


    @Test
    @Order(3)
    @DisplayName("Follow A Seller In existing.")
    void followASellerTest() throws Exception {


        MvcResult response = mvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2)
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals("El Usuario: Juan ahora sigue al Vendedor: Pedro", response.getResponse().getContentAsString());
    }

    @Test
    @Order(4)
    @DisplayName("Get Count Followers By Seller.")
    void getCountFollowersBySellerTest() throws Exception {

        mvc.perform(get("/users/{userId}/followers/count", 2)
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @Order(5)
    @DisplayName("Get Count Followers By Seller In Existing.")
    void getCountFollowersBySellerInExistingTest() throws Exception {

        mvc.perform(get("/users/{userId}/followers/count", 3)
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isBadRequest());

    }


}