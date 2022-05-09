package com.sprint.be_java_hisp_w15_g10.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductRequestDTO;
import com.sprint.be_java_hisp_w15_g10.Exception.CategoryNotFoundPostException;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
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


    /**
     * Valida la excepción lanzada al enviar un producto nulo
     */
    @Test
    @DisplayName("Test Product null")
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

    /**
     * Valida la excepción lanzada al enviar un id de categoría no existente en el repositorio
     */
    @Test
    @DisplayName("Test Category Null")
    void createPostCategoryNotFoundIntTest() throws Exception {

        //Arrange
        PostCreateDTO postCreateDTO1 = postCreateDTO;

        postCreateDTO1.setCategory_id(100);

        String json = writer.writeValueAsString(postCreateDTO1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(json);
        //Assert

        mockMvc.perform(request)
                .andDo(
                        MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> {
                            Assertions.assertTrue(result.getResolvedException() instanceof CategoryNotFoundPostException);
                        }
                );

    }

    /**
     * Valida el guardado correcto del post
     */
    @Test
    @DisplayName("Test creaciòn post")
    void createPostIntTest() throws Exception {

        //Arrange
        String json = writer.writeValueAsString(postCreateDTO);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(json);
        //Assert

        mockMvc.perform(request)
                .andDo(
                        MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );

    }

}
