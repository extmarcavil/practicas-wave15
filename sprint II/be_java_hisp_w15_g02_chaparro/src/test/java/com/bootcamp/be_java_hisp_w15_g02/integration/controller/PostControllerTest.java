package com.bootcamp.be_java_hisp_w15_g02.integration.controller;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.ProductDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.PostsBySellersDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test integral para crear un post sin descuento.")
    void testCreatePost() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        ProductDTO product = new ProductDTO(1000,"Barredora","Grande","Pesada","Negra","Es muy grande");

        PostCreateDTO post = new PostCreateDTO(5, LocalDate.parse("2021-05-06"),product,"100",15000);

        String payload = writer.writeValueAsString(post);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Test integral para invalidar la creación de un post.")
    void testCreatePostUserNotFound() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        ProductDTO product = new ProductDTO(1000,"Barredora","Grande","Pesada","Negra","Es muy grande");

        PostCreateDTO post = new PostCreateDTO(122, LocalDate.parse("2021-05-06"),product,"100",15000);

        String payload = writer.writeValueAsString(post);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Test integral para traer la lista de posts de los vendedores que sigue un usuario.")
    void testCreatePostWrong() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()).setDateFormat(new SimpleDateFormat("yyyy-MM-dd")) // convertir fechas
                .writer();

        Product product1 = new Product(5,"iphone XR","electronic","apple","white","iphone 128 GB");
        Product product2 = new Product(2,"iphone 12","electronic","apple","rose gold","iphone 64 GB");
        Product product3 = new Product(6,"cama","electronic","apple","white","cama grande");
        Post post1 = new Post(5,5,LocalDate.of(2022,5,6),5,product1,5000);
        Post post2 = new Post(2,4,LocalDate.of(2022,4,25),2,product2,10000);
        Post post3 = new Post(6,5,LocalDate.of(2022,5,3),5,product3,6000);
        List<PostsBySellersDTO> postList = new ArrayList<>();
        postList.add(new PostsBySellersDTO(post1));
        postList.add(new PostsBySellersDTO(post2));
        postList.add(new PostsBySellersDTO(post3));

        GetPostsSellerByUserIdDTO getListPost = new GetPostsSellerByUserIdDTO(1,postList);

        String jsonExpected = writer.writeValueAsString(getListPost);
        System.out.println(jsonExpected);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{id}/list?order=date_desc",1);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

    @Test
    @DisplayName("Test integral para traer la lista de posts de los vendedores que sigue un usuario con un orden inexistente.")
    void testOrderWrong() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()).setDateFormat(new SimpleDateFormat("yyyy-MM-dd")) // convertir fechas
                .writer();

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{id}/list?order=same",1);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                );
    }
}
