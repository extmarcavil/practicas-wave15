package com.sprint1.be_java_hisp_w15_g4.integration_test;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * Este test debe ejecutarse con Run All para que tenga sentido.
 * No tiene sentido ejecutarlo individuales debido a que el contexto de
 * Spring se reiniciara.
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UseCaseFollow {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Verifica que el correcto seguimiento del user 1 al user 2")
    @Order(1)
    void followUserOk() throws Exception {

        int idUser=1;
        int idUserToFollow=2;


        ResultMatcher status= MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{user_id}/follow/{userIdToFollow}",idUser,idUserToFollow);

        mockMvc.perform(req)
                .andExpectAll(
                        status
                );
    }


    @Test
    @DisplayName("Verifica que se lanza una excepcion porq el usuario ya sigue a dicho usuario")
    @Order(2)
    void followUserNotOk() throws Exception {

        int idUser=1;
        int idUserToFollow=2;

        String jsonExpect="{\"mensaje\":\"El usuario 1 ya sigue al usuario 2\",\"status\":\"CONFLICT\"}";

        ResultMatcher status= MockMvcResultMatchers.status().isConflict();
        ResultMatcher bodyResponse= MockMvcResultMatchers.content().json(jsonExpect);

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{user_id}/follow/{userIdToFollow}",idUser,idUserToFollow);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        bodyResponse
                );
    }


    @Test
    @DisplayName("Verifica que se lanza una excepcion xq el usuario a seguir es el mismo")
    @Order(3)
    void followUserNotOkIdEquals() throws Exception {

        int idUser=1;
        int idUserToFollow=1;

        String jsonExpect="{\"mensaje\":\"Los id deben ser diferentes: 1\",\"status\":\"CONFLICT\"}";

        ResultMatcher status= MockMvcResultMatchers.status().isConflict();
        ResultMatcher bodyResponse= MockMvcResultMatchers.content().json(jsonExpect);

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{user_id}/follow/{userIdToFollow}",idUser,idUserToFollow);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        bodyResponse
                );
    }
}
