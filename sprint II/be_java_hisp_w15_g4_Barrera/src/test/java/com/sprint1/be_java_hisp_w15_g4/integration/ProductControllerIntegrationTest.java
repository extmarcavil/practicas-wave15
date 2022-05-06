package com.sprint1.be_java_hisp_w15_g4.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g4.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w15_g4.model.Post;
import com.sprint1.be_java_hisp_w15_g4.model.User;
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
    @DisplayName("Verifica que se estan cotando los seguidores del usuario correcto")
    void A_PostProductOk() throws Exception {
        ObjectWriter writer =  new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        //Arrange
        PostDTO dto = getPost();

        //Expected
        ResultMatcher expectedStatus= MockMvcResultMatchers.status().isOk();

        //Request
        String payloadJson = writer.writeValueAsString(dto).replace("[2022,5,2]", "\"02-05-2022\"");

        //Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(expectedStatus);

    }

    private PostDTO getPost() {
        ProductDTO product = new ProductDTO();
        product.setProduct_id(1);
        product.setProduct_name("name");
        product.setType("type");
        product.setBrand("brand");
        product.setColor("color");
        product.setNotes("notes");

        PostDTO post = new PostDTO();
        post.setUser_id(1);
        post.setPost_id(1);
        post.setDate(LocalDate.of(2022,5,2));
        post.setDetail(product);
        post.setCategory(1);
        post.setPrice(1.55);

        return post;
    }
}
