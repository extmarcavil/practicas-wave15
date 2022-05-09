package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.ProductDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void initDataTest(){
        new UserRepositoryImpl();
    }

    @Test
    @DisplayName("Creación incorrecta de una publicación")
    void whenCreateNewPostThenReturnsOk() throws Exception {
        // Arrange
        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer",
                "Black", "Special Edition");

        RequestPostDTO requestPostDTO = new RequestPostDTO();
        requestPostDTO.setUser_id(1);
        requestPostDTO.setDate(LocalDate.now());
        requestPostDTO.setDetail(product);
        requestPostDTO.setCategory("silla");
        requestPostDTO.setPrice(100.00);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post", requestPostDTO))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

}