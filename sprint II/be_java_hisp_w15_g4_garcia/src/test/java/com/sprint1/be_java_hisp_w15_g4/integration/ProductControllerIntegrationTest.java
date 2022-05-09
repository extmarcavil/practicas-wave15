package com.sprint1.be_java_hisp_w15_g4.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g4.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.model.Post;
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
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Se prueba crear un post")
    void testCreateAPost() throws Exception{

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        ProductDTO product = new ProductDTO();
        product.setProduct_id(1);
        product.setProduct_name("silla");
        product.setType("mueble");
        product.setBrand("generica");
        product.setColor("madera");
        product.setNotes("nada");

        PostDTO postDTO = new PostDTO();
        postDTO.setUser_id(1);
        postDTO.setPost_id(1);
        postDTO.setDate(LocalDate.of(2022,5,6));
        postDTO.setDetail(product);
        postDTO.setCategory(1);
        postDTO.setPrice(100);

        String createPostJson = writer.writeValueAsString(postDTO).replace("[2022,5,6]", "\"06-05-2022\"");
        MockHttpServletRequestBuilder createAPost = MockMvcRequestBuilders.post("/products/post").content(createPostJson);
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(createPostJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(createAPost)
                .andDo(MockMvcResultHandlers.print());

    }


}
