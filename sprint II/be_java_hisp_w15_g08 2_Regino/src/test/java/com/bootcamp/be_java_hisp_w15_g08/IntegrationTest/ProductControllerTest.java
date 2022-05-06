package com.bootcamp.be_java_hisp_w15_g08.IntegrationTest;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g08.util.Util;
import com.bootcamp.be_java_hisp_w15_g08.util.Utils2;
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

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createPost() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Arrange
        NewPostDTO post = Utils2.newPostDTO1();
        String postJson = writer.writeValueAsString(post);

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson);


        //ACT

        //Assert
        mockMvc.perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
    }

    @Test
    public void getSellersLastsPosts() throws Exception{

        //Arrange
        Integer id = 1234;

        //Expected
        ResultMatcher expextedStatus = MockMvcResultMatchers.status().isAccepted();

        //Request
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/products/followed/{userId}/list",id);

        //ACT

        //Assert
        mockMvc.perform(req)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expextedStatus
                );
        //Para poder comparar la respuesta hace falta introducir los datos al repositorio.
    }
}
