package com.example.be_java_hisp_w15_g05.integration;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResCreatePostDTO;
import com.example.be_java_hisp_w15_g05.exceptions.ErrorDTO;
import com.example.be_java_hisp_w15_g05.utils.ErrorsFactory;
import com.example.be_java_hisp_w15_g05.utils.PostFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void postOk() throws Exception {
        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())//Convertir la fecha
                .writer();

        ResCreatePostDTO resCountFollowersDTO = new ResCreatePostDTO("La publicación se ha creado con éxito");
        String resJson = writer.writeValueAsString(resCountFollowersDTO);
        //lo que le envio
        PostDTO postDTO = PostFactory.galperinNewPostDTO();
        // Expected
        // EXPECTED
        ResultMatcher expecteJson = MockMvcResultMatchers.content().json(resJson);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO));

        //act & assert
        mockMvc
                .perform(req)
                .andExpectAll(expectedStatus,expecteJson);
    }

    @Test
    void postNotActualDate() throws Exception {
        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())//Convertir la fecha
                .writer();

        //lo que le envio
        PostDTO postDTO = PostFactory.errorDatePostDTO();
        // Expected
        // EXPECTED
        ResultMatcher expecteJson = MockMvcResultMatchers.content().string("La fecha de la publicacion debe ser a partir de hoy.");
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO));

        //act & assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus,expecteJson);
    }

    @Test
    void postNot() throws Exception {
        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())//Convertir la fecha
                .writer();

        //lo que le envio
        PostDTO postDTO = PostFactory.errorPostDTO();
        // Expected
        // EXPECTED
        ErrorDTO errorDTO = ErrorsFactory.postErrorDTO();
        String errorJson = writer.writeValueAsString(errorDTO);

        ResultMatcher expecteJson = MockMvcResultMatchers.content().json(errorJson);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO));

        //act & assert
        mockMvc
                .perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus,expecteJson);
    }
}
