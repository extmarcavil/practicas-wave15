package com.example.be_java_hisp_w15_g07.integration.controller;

import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;
import com.example.be_java_hisp_w15_g07.dto.request.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    void setup(){
        this.writer =  new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("products/post -> agrega correctamente un nuevo POST a un usuario")
    void newPostTest() throws Exception {
        // Arrange
        NewPostDTO newPost = new NewPostDTO();
        newPost.setUserId(2);
        newPost.setDate(LocalDate.now());

        ProductDTO detalle = new ProductDTO();
        detalle.setBrand("MarcaRandom");
        detalle.setColor("Gris");
        detalle.setProductId(23);
        detalle.setNotes("Es un producto para TEST");
        detalle.setType("TestProduct");
        detalle.setProductName("Test-Product");

        newPost.setDetail(detalle);
        newPost.setCategory(3);
        newPost.setPrice(5500D);

        String payloadJson = writer.writeValueAsString(newPost);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post");

        mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("products/post -> lanza excepción al intentar agregar usuario con payload incompleto")
    void newPostFailsTest() throws Exception {
        NewPostDTO newPost = new NewPostDTO();
        String payloadJson = writer.writeValueAsString(newPost);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post");

        mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
