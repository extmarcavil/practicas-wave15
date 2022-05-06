package com.example.be_java_hisp_w15_g05.integration_test;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResCreatePostDTO;
import com.example.be_java_hisp_w15_g05.exceptions.ErrorDTO;
import com.example.be_java_hisp_w15_g05.utils.PostFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
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

@SpringBootTest
@AutoConfigureMockMvc
public class ControllersIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test Integración de cantidad de seguidores (get)")
    void integrationTestCountFollowers() throws Exception{

        ObjectWriter writer =  new ObjectMapper().writer();

        //arrange
        //crea una persona
        ResCountFollowersDTO dto = new ResCountFollowersDTO(1, "Marcos Galperin", 2);
        String respJson = writer.writeValueAsString(dto);

        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().json(respJson);

        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", 1);

        //act & assert
        mockMvc.perform(request)
                .andExpectAll(expectedStatus, expectedContentType);
    }

    @Test
    @DisplayName("Test Integración para crear un post (post)")
    void integrationTestCreatePost() throws Exception{

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //arrange
        //se crea el payload y el mensaje de respuesta de post creado
        PostDTO post = PostFactory.createPost();
        ResCreatePostDTO resPost = PostFactory.createResPost();
        String payload = writer.writeValueAsString(post);
        String expected = writer.writeValueAsString(resPost);

        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expected);

        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON).content(payload);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("Test Integración para crear un post con error (post)")
    void integrationTestCreatePostError() throws Exception{

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //arrange
        //se crea el payload y el mensaje de respuesta de post creado
        //si el test falla, es porque la fecha no es del día de hoy en la clase PostFactory, método createPost().
        PostDTO post = PostFactory.createPostError();
        ErrorDTO errorPost = new ErrorDTO();
        String payload = writer.writeValueAsString(post);
        String expected = writer.writeValueAsString(errorPost);

        //expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expected);

        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON).content(payload);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }
}
