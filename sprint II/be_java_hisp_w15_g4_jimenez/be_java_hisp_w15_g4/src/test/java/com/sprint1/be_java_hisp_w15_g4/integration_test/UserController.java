package com.sprint1.be_java_hisp_w15_g4.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sprint1.be_java_hisp_w15_g4.dto.response.ErrorDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.IdNotPositiveErrorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class UserController {

    @Autowired
    MockMvc mockMvc;

    @Test
    void followUserNotExists() throws Exception {

        ObjectWriter writer= new ObjectMapper().writer();

        int idUser=1;
        int idUserToFollow=7;

        ErrorDTO expected= new ErrorDTO("No se ha encontrado el usuario: 7", HttpStatus.NOT_FOUND);
        String jsonString= writer.writeValueAsString(expected);

        ResultMatcher status= MockMvcResultMatchers.status().isNotFound();
        ResultMatcher json=MockMvcResultMatchers.content().json(jsonString);
        ResultMatcher contentType=MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{user_id}/follow/{userIdToFollow}",idUser,idUserToFollow);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        json,
                        contentType
                );
    }


    @Test
    void followUserBadUserId() throws Exception {

        ObjectWriter writer= new ObjectMapper().writer();

        int idUser=-1;
        int idUserToFollow=-7;

        IdNotPositiveErrorDTO expected= new IdNotPositiveErrorDTO(
                HttpStatus.BAD_REQUEST,
                Map.of("userId","El id debe ser mayor a cero.",
                        "userIdToFollow","El id debe ser mayor a cero.")
        );
        String jsonString= writer.writeValueAsString(expected);

        ResultMatcher status= MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher json=MockMvcResultMatchers.content().json(jsonString);
        ResultMatcher contentType=MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/users/{user_id}/follow/{userIdToFollow}",idUser,idUserToFollow);

        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        json,
                        contentType
                );
    }

}
