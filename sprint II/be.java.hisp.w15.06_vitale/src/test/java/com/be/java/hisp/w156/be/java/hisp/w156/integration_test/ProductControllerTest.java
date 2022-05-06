package com.be.java.hisp.w156.be.java.hisp.w156.integration_test;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.ProductDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ErrorDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Verificar la correcta creación de una publicación.")
    void whenCreateNewPostThenReturnsOk() throws Exception {
        // Arrange

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();


        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer",
                "Red and Black", "Special Edition");

        RequestPostDTO requestPostDTO = new RequestPostDTO();
        requestPostDTO.setUser_id(1);
        requestPostDTO.setDate(LocalDate.now());
        requestPostDTO.setDetail(product);
        requestPostDTO.setCategory("100");
        requestPostDTO.setPrice(1500.50);

        String messageExpected = "Post with ID: 1 was saved successfully";
        SuccessDTO successDTO = new SuccessDTO(messageExpected);

        String recipePayload = writer.writeValueAsString(requestPostDTO);
        String expectedBody = writer.writeValueAsString(successDTO);

        // Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
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

    @Test
    @DisplayName("Verificar que al intentar crear una publicación con atributos invalidos muestre mensajes con error.")
    void whenCreateNewPostWithInvalidAttributesThenReturnsErrorMessage() throws Exception {
        // Arrange

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();


        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer",
                "Red & Black", "Special Edition");

        RequestPostDTO requestPostDTO = new RequestPostDTO();
        requestPostDTO.setUser_id(1);
        //El valor de la fecha (date) no se setea para obtener el mensaje de error.
        requestPostDTO.setDetail(product);
        requestPostDTO.setCategory("100");
        //El valor del precio (price) es invalido para obtener el mensaje de error.
        Double invalidPrice = 20000000D;
        requestPostDTO.setPrice(invalidPrice);

        HashMap<String, List<String>> errors = new HashMap<>();
        errors.put("date", Arrays.asList("La fecha no puede estar vacía."));
        errors.put("price", Arrays.asList("El precio máximo por producto es de 10.000.000"));
        ErrorDTO errorDTO = new ErrorDTO("Algunos valores de entrada son incorrectos.", errors);

        String recipePayload = writer.writeValueAsString(requestPostDTO);
        String expectedBody = writer.writeValueAsString(errorDTO);

        // Expected
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