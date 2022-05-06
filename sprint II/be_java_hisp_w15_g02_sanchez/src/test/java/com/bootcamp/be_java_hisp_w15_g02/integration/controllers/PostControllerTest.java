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
public class PostControllerTest {
    @Autowired
    MockMvc _mockMvc;

    @Test
    @DisplayName("valid create new post")
    void createPostValid() throws  Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GlobalIntegration.jsonFormat(GlobalIntegration.postDummy())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("invalid in new post")
    void createPostInvalid() throws  Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GlobalIntegration.jsonFormat(GlobalIntegration.postInvalidDummy())))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                                MockMvcResultMatchers.status().isNotFound(),
                                MockMvcResultMatchers
                                        .jsonPath("$.message")
                                        .value("El usuario no existe.")
                             );
    }

    @Test
    @DisplayName("valid list follows by user")
    void  listPostByFollowUserWithoutOrder() throws  Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers
                                .jsonPath("$.posts.length()")
                                .value(3)
                );
    }

    @Test
    @DisplayName("valid list follows by user ordered")
    void  listPostByFollowUserWithOrder() throws  Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list?order=date_asc",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers
                                .jsonPath("$.posts.length()")
                                .value(3)
                );
    }

    @Test
    @DisplayName(" type order not valid in list follows")
    void invalidTypeOrder() throws Exception{
        //arr & act & assert
        _mockMvc
                .perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list?order=date_testing",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers
                                .jsonPath("$.message")
                                .value("Tipo de orden no válido.")
                );
    }
}
