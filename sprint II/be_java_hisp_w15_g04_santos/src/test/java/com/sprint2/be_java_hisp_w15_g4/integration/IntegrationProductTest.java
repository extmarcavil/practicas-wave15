package com.sprint2.be_java_hisp_w15_g4.integration;

import Utils.TestGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint2.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint2.be_java_hisp_w15_g4.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationProductTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;


    @BeforeAll
    public static void setUp() {
        new UserRepository();

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }


    @Test
    @DisplayName("Save new post")
    void postProductTest() throws Exception {

        PostDTO postDTO = TestGenerator.GeneratePostDTO("02-05-2022");

        String newPostToSave = writer.writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .content(newPostToSave)
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get latest posts")
    void getLatestPostTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts.length()").value(0));
    }

}