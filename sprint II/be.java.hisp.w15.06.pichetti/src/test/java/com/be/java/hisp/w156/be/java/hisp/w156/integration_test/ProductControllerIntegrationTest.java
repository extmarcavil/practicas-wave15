package com.be.java.hisp.w156.be.java.hisp.w156.integration_test;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.*;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName(" [Integration Test] - Creación de Post con mensaje de éxito ")
    void whenCreatePost_thenReturnMessageSuccessfull() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        Product product = new Product(1,"Silla","Gamer","Racer","Red","Special");
        RequestPostDTO requestPostDTO = new RequestPostDTO(1, LocalDate.now(), product, "100", 100.00);

        SuccessDTO successDTO = new SuccessDTO("Post with ID: 1 was saved successfully");

        String postPayload = writer.writeValueAsString(requestPostDTO);
        String expectedBody = writer.writeValueAsString(successDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postPayload);
        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }



    @Test
    @DisplayName(" [Integration Test] - Creación de Post con atributos inválidos con mensaje de error ")
    void whenCreatePostWithInvalidAttributes_thenReturnsErrorMessage() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        // Arrange
        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer",
                "Red & Black", "Special Edition");

        RequestPostDTO requestPostDTO = new RequestPostDTO();
        requestPostDTO.setUser_id(1);
        // El valor de fecha no se setea para obtener el mensaje de error.
        requestPostDTO.setDetail(product);
        requestPostDTO.setCategory("100");
        // Seteamos un valor del precio invalido para obtener el mensaje de error.
        Double invalidPrice = 50000000D;
        requestPostDTO.setPrice(invalidPrice);

        HashMap<String, List<String>> errores = new HashMap<>();
        errores.put("date", Arrays.asList("La fecha no puede estar vacía."));
        errores.put("price", Arrays.asList("El precio máximo por producto es de 10.000.000"));
        ErrorDTO errorDTO = new ErrorDTO("Algunos valores de entrada son incorrectos.", errores);

        String recipePayload = writer.writeValueAsString(requestPostDTO);
        String expectedBody = writer.writeValueAsString(errorDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(recipePayload);

        // Act & Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

}
