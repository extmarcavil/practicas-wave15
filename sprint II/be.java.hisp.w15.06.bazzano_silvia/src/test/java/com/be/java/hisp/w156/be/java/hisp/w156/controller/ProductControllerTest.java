package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.ProductDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.UserRepositoryImpl;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IProductService;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    IProductService service;

    @InjectMocks
    UserController controller;

    @BeforeEach
    public void initDataTest(){
        new UserRepositoryImpl();
    }

    @Test
    @DisplayName("Creación incorrecta de una publicación.")
    void whenCreateNewPostThenReturnsOk() throws Exception {
        // Arrange
        ObjectWriter writer =  new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer",
                "Black", "Special Edition");

        RequestPostDTO requestPostDTO = new RequestPostDTO();
        requestPostDTO.setUser_id(1);
        requestPostDTO.setDate(LocalDate.now());
        requestPostDTO.setDetail(product);
        requestPostDTO.setCategory("silla");
        requestPostDTO.setPrice(100.00);

        SuccessDTO successDTO = new SuccessDTO("Publicación con id 1 se guardo correctamente");

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post", requestPostDTO))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }
}