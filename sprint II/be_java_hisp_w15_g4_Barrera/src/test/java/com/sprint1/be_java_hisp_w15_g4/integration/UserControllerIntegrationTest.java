package com.sprint1.be_java_hisp_w15_g4.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g4.dto.UserDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.ErrorDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Para definir el orden en que se ejecutan los test
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    ////////////////////US0002////////////////////
    //La letra al comienzo del nombre del metodo es para definir el orden en que se realizan (no puede hacer andar la anotattion @order)
    @Test
    @Order(1)
    @DisplayName("Verifica que se estan cotando los seguidores del usuario correcto")
    void folowersListOk() throws Exception {
        ObjectWriter writer =  new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        //Arrange
        int idUser=1;
        FollowerCountDTO dto = new FollowerCountDTO(idUser,"nombre1",0);
        String userJson = writer.writeValueAsString(dto);

        //Expected
        ResultMatcher expetedStatus= MockMvcResultMatchers.status().isOk();
        ResultMatcher expetedJson= MockMvcResultMatchers.content().json(userJson);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{user_id}/followers/count",idUser);

        //Act & Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expetedJson,expetedStatus);

    }

    ////////////////////US0001////////////////////
    @Test
    @Order(2)
    @DisplayName("Verifica que un usuario siga a otro de forma correcta")
    void followUserOK() throws Exception {

        //Arrange
        int idUser=1;
        int idUserToFollow = 2;

        //Expected
        ResultMatcher expetedStatus= MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{user_id}/follow/{userIdToFollow}",idUser,idUserToFollow);

        //Act & Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expetedStatus);

    }

    @Test
    @Order(3)
    @DisplayName("Verifica que un usuario ya seguia a otro y devuelve un error")
    void alreadyFollowing() throws Exception {
        ObjectWriter writer =  new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        //Arrange
        int idUser=1;
        int idUserToFollow = 2;
        ErrorDTO dto = new ErrorDTO("El usuario 1 ya sigue al usuario 2", HttpStatus.CONFLICT);
        String error = writer.writeValueAsString(dto);

        //Expected
        ResultMatcher expetedStatus= MockMvcResultMatchers.status().isConflict();
        ResultMatcher expetedJson= MockMvcResultMatchers.content().json(error);


        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{user_id}/follow/{userIdToFollow}",idUser,idUserToFollow);

        //Act & Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expetedStatus,expetedJson);

    }






}
