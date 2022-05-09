package com.bootcamp.be_java_hisp_w15_g08.Units;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.util.Util;
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
public class PostControllerTest {


    @Autowired
    MockMvc mvc;

    @Test
    public void createPost() throws Exception{
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        NewPostDTO newPost = Util.newPost();
        String expectedJson = writer.writeValueAsString(newPost);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isAccepted();


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON).content(expectedJson);

        mvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);

    }

    @Test
    public void getSellersLastsPosts() throws Exception{
        Integer user_id1 = 1234;

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isAccepted();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list",user_id1);

        mvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }
}