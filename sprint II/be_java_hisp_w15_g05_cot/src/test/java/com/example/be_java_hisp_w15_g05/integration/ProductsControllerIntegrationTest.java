package com.example.be_java_hisp_w15_g05.integration;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.PostIdDTO;
import com.example.be_java_hisp_w15_g05.dto.ResPostListDTO;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import com.example.be_java_hisp_w15_g05.repository.UserRepository;
import com.example.be_java_hisp_w15_g05.service.ProductsService;
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

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static IUserRepository repository = new UserRepository();
    static ProductsService service = new ProductsService(repository);

    @Test
    public void postTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        PostDTO post = PostFactory.getPost();

        String json = writer.writeValueAsString(post);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void postMethodArgumentNotValidExceptionTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        PostDTO post = PostFactory.getInvalidPost();

        String json = writer.writeValueAsString(post);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void getListSellerPostTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        List<PostIdDTO> posts = PostFactory.getListSellerPost();
        ResPostListDTO response = new ResPostListDTO(10, posts);


        String json = writer.writeValueAsString(response);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(json);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 10))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }
}
