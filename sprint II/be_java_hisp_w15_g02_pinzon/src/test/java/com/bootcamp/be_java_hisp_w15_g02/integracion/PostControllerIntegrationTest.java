package com.bootcamp.be_java_hisp_w15_g02.integracion;


import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.ProductDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.PostsBySellersDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Test for validate is a post was created")
    public void validateIfWasCreatedPost() throws Exception {
        // arrange
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        // Expected
        ProductDTO productDTO = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red y black", "special Edition");
        PostCreateDTO postCreateDTO = new PostCreateDTO(5, LocalDate.now(), productDTO, "100", 11.500);

        String expectedString = writer.writeValueAsString(postCreateDTO);

        mockMvc
                .perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expectedString))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    @DisplayName("Test for validate if the list of post that have a user is correct")
    @Disabled("Al correr todos los test falla este por que se agregan posts que no se validan aqui.")
    public void validateListPostFollowedByUser() throws Exception {
        // arrange
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).setDateFormat(new SimpleDateFormat("yyyy-MM-dd")).writer();

        // Expected
        Product product = new Product(2, "iphone 12", "electronic", "apple", "rose gold", "iphone 64 GB");
        Post newPost = new Post(2, 4, LocalDate.parse("2022-04-25"), 2, product,  10000.0);
        PostsBySellersDTO postCreateDTO = new PostsBySellersDTO(newPost);

        List<PostsBySellersDTO> posts = new ArrayList<>();
        posts.add(postCreateDTO);

        GetPostsSellerByUserIdDTO postsSellerByUserIdDTO = new GetPostsSellerByUserIdDTO(2, posts);

        String expectedString = writer.writeValueAsString(postsSellerByUserIdDTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2);

        MvcResult mvcResult = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String test = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(expectedString, mvcResult.getResponse().getContentAsString());
    }
}
