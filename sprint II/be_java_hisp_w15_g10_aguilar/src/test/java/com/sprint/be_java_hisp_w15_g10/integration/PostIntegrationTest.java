package com.sprint.be_java_hisp_w15_g10.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
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

    /**
     * Valida que no se pueda crear un post nulo y tire la respuesta correspondiente
     *
     * @throws Exception
     */

    @Test
    @DisplayName("Test crear Post nulo")
    void createPostNullIntegrationTest() throws Exception {


        //Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        PostCreateDTO postCreateDTO = new PostCreateDTO(1, null, LocalDate.now(), 1, 20.0);
        String json = writer.writeValueAsString(postCreateDTO);

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
     * Valida que se pueda crear un post y retorne la respuesta correspondiente
     *
     * @throws Exception
     */
//    @Test
//    @DisplayName("Test creacion de post controlador")
//    void createPostIntegrationTest() throws Exception {
//
//        ObjectWriter writer = new ObjectMapper()
//                .registerModule(new JavaTimeModule())
//                .writer();
//
//        //Arrange
//
//
//        //Creacion de un post y producto para el test
//
//        ProductRequestDTO producto = new ProductRequestDTO(1, "Producto 1", "hogar", "samsung", "rojo", "nmdfiodsf");
//
//        PostCreateDTO Post = new PostCreateDTO(1, producto
//                , LocalDate.now(), 1, 20.0);
//
//        String payloadPost = writer.writeValueAsString(Post);
//        String expectedPost = writer.writeValueAsString(Post);
//
//        //Expected
//        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
//        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedPost);
//        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
//
//
//        //Request
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(payloadPost);
//
//        //Act & Assert
//        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
//                .andExpectAll(
//                        expectedStatus,
//                        expectedJson,
//                        expectedContentType);
//
//    }


}
