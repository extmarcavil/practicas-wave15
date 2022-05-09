package com.bootcamp.be_java_hisp_w15_g08.Integration;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.DetailDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
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
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("test add post ")
    void createPostIntegrationTest() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // arrange

        NewPostDTO post = new NewPostDTO();

        DetailDTO detail = new DetailDTO();

        detail.setBrand("Asus");
        detail.setColor("Red");
        detail.setNotes("no");
        detail.setProduct_id(3);
        detail.setType("Test");
        detail.setProduct_name("TEclado?");

        post.setUser_id(1234);
        post.setCategory(1);
        post.setDate(LocalDate.now());
        post.setPrice(75000);
        post.setDetail(detail);

        PostNotUserIdDTO response = new PostNotUserIdDTO();



        detail.setBrand("Asus");
        detail.setColor("Red");
        detail.setNotes("no");
        detail.setProduct_id(3);
        detail.setType("Test");
        detail.setProduct_name("TEclado?");


        response.setCategory(1);
        response.setPostID(1);
        response.setDate(LocalDate.now());
        response.setPrice(75000);
        response.setDetail(detail);




        /*recipes.add(recipe);*/
        // body?
        // endpoint -> parametros
        // except

        System.out.println(post.getPostID());
        String recipePayload = writer.writeValueAsString(post);
        String expectedBody = writer.writeValueAsString(response);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(recipePayload);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }
}
