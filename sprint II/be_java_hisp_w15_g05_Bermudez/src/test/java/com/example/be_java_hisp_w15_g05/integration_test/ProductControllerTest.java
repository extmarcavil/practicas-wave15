package com.example.be_java_hisp_w15_g05.integration_test;


import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.utils.PostFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName(" Integracion - Crear un post ")
    void createPostTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        // arrange
        PostDTO post = PostFactory.createPost();
        ResCreatePostDTO resCreatePostDTO = new ResCreatePostDTO("La publicación se ha creado con éxito");

        String postPayload = writer.writeValueAsString(post);
        String expectedBody = writer.writeValueAsString(resCreatePostDTO);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(postPayload);

        // act & assert
        mockMvc.perform(request)
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContent
                );
    }

    @Test
    @DisplayName(" Usuario no encontrado al crear un post ")
    void userNotFoundExceptionPostTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        // arrange
        ProductDTO producto = PostFactory.getpDTO2();
        PostDTO postInvalido = new PostDTO(90, LocalDate.of(2020,5,2),producto,200,1501.00);
        String postPayload = writer.writeValueAsString(postInvalido);

        // expect
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        //ResultMatcher expectedContent = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(postPayload);

        // act & assert
        mockMvc.perform(request)
                .andExpectAll(
                        expectedStatus
                        //expectedContent
                );
    }

    @Test
    void getFollowedVendorPosts() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        // arrange
        List<PostIdDTO> listedPosts = PostFactory.getListPostsAsc();
        ResPostListDTO resListedPosts = new ResPostListDTO(10,listedPosts);
        String expectedBody = writer.writeValueAsString(resListedPosts);

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 10);

        // act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContent
                );


    }
}
