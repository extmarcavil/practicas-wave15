package com.sprint.be_java_hisp_w15_g10.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductRequestDTO;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
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

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer;
    ProductRequestDTO productRequestDTO;
    PostCreateDTO postCreateDTO;

    @BeforeEach
    void setup(){
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();
        productRequestDTO = TestUtils.createProductRequestDTO();
        postCreateDTO = TestUtils.createPostCreateDTO(productRequestDTO);
    }


    @Test
    @DisplayName("Test Post")
    void createPostProductNullIntTest() throws Exception {

        //Arrange
        PostCreateDTO postCreateDTO1 = postCreateDTO;
        postCreateDTO1.setDetail(null);
        String json = writer.writeValueAsString(postCreateDTO1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(json);
        //Assert

        mockMvc.perform(request)
                .andDo(
                        MockMvcResultHandlers.print())
                .andExpect(expectedStatus);

    }

    @Test
    @DisplayName("Test Post")
    void createPostCategorNotFoundIntTest() throws Exception {

        //Arrange
        PostCreateDTO postCreateDTO1 = postCreateDTO;
        postCreateDTO1.setCategory_id(1);

        String json = writer.writeValueAsString(postCreateDTO1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(json);
        //Assert

        mockMvc.perform(request)
                .andDo(
                        MockMvcResultHandlers.print())
                .andExpect(expectedStatus);

    }

}
