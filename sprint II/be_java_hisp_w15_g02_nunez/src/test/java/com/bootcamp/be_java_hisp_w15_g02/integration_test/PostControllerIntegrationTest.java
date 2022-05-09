package com.bootcamp.be_java_hisp_w15_g02.integration_test;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.ProductDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.PostsBySellersDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    private String url;
    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer;

    @BeforeEach
    void setup() {
        url = "/products";
        this.writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()).setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .writer();
    }

    @Test
    @DisplayName("Creacion de un post con datos validos")
    void createPostValidData() throws Exception {
        // arrange
        PostCreateDTO post = new PostCreateDTO(
                                    2, LocalDate.parse("2022-04-25"),
                                    new ProductDTO(2,"iphone 12","electronic","apple","rose gold",
                                            "iphone 64 GB"), "1",10000);
        String jsonPost = writer.writeValueAsString(post);

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedString = MockMvcResultMatchers.content().string("");
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.valueOf("text/plain;charset=UTF-8"));

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url + "/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPost);

        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedString, expectedContentType);
    }

    @Test
    @DisplayName("Obtener los post de un usuario valido.")
    void getPostsValidData() throws Exception {
        // arrange
        List<PostsBySellersDTO> postsExpected = new ArrayList<>();
        postsExpected.add(
                new PostsBySellersDTO(new Post(5,5, LocalDate.parse("2022-05-08"),5,
                        new Product(5,"iphone XR","electronic","apple","white",
                                "iphone 128 GB"),5000)));
        postsExpected.add(
                new PostsBySellersDTO(new Post(6,5, LocalDate.parse("2022-05-03"),5,
                        new Product(6,"cama","electronic","apple","white",
                                "cama grande"),6000)));
        int validUserId = 1;
        List<PostsBySellersDTO> postsExpected1 = new ArrayList<>();
        GetPostsSellerByUserIdDTO postSellerDTO = new GetPostsSellerByUserIdDTO(1, postsExpected);
        String jsonPosts = writer.writeValueAsString(postSellerDTO);

        // expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedString = MockMvcResultMatchers.content().json(jsonPosts);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url + "/followed/{userId}/list", validUserId);

        // act & assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus, expectedString, expectedContentType);
    }
}