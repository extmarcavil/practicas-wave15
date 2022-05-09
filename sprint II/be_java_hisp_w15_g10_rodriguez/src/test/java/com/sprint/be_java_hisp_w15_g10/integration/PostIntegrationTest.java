package com.sprint.be_java_hisp_w15_g10.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductRequestDTO;
import org.hamcrest.Matchers;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
    @DisplayName("Test crear Post con producto nulo")
    void createPostNullProductIntegrationTest() throws Exception {

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
                .andExpectAll(
                        expectedStatus,
                        jsonPath("$.detail").value("no puede ser null"));
    }

    @Test
    @DisplayName("Test crear Post con datos invalidos")
    void createPostInvalidPostIntegrationTest() throws Exception {

        //Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        PostCreateDTO postCreateDTO = new PostCreateDTO(1, new ProductRequestDTO(), LocalDate.now(), 1, 900.0);
        String json = writer.writeValueAsString(postCreateDTO);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(json);
        //Assert

        mockMvc.perform(request)
                .andDo(
                        MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        jsonPath("$.['detail.brand']").value("El campo no puede estar vacío"),
                        jsonPath("$.['detail.color']").value("El campo no puede estar vacío"),
                        jsonPath("$.['detail.product_name']").value("El campo no puede estar vacío"),
                        jsonPath("$.['detail.product_id']").value("La id no puede estar vacía"),
                        jsonPath("$.['detail.type']").value("El campo no puede estar vacío"));
    }

    @Test
    @DisplayName("Test crear Post con producto invalido")
    void createPostInvalidProductIntegrationTest() throws Exception {

        //Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        PostCreateDTO postCreateDTO = new PostCreateDTO(0, null, null, 0, 1234567890.0);
        String json = writer.writeValueAsString(postCreateDTO);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(json);
        //Assert

        mockMvc.perform(request)
                .andDo(
                        MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        jsonPath("$.detail").value("no puede ser null"),
                        jsonPath("$.date").value("La fecha no puede estar vacía"),
                        jsonPath("$.category_id").value("El category_id debe ser mayor a cero"),
                        jsonPath("$.price").value("El precio máximo por producto es de 10.000.000"),
                        jsonPath("$.user_id").value("El id debe ser mayor a cero"));
    }


    /**
     * Valida que se pueda crear un post y retorne la respuesta correspondiente
     *
     * @throws Exception
     */
    @Test
    @DisplayName("Test creacion de post controlador")
    void createPostIntegrationTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Arrange


        //Creacion de un post y producto para el test

        ProductRequestDTO producto = new ProductRequestDTO(1, "Producto 1", "hogar", "samsung", "rojo", "nmdfiodsf");

        PostCreateDTO Post = new PostCreateDTO(1, producto
                , LocalDate.now(), 1, 20.0);

        String payloadPost = writer.writeValueAsString(Post);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadPost);

        //Act & Assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        jsonPath("$.message").value("Se ha creado el Post con éxito"));

    }

    /**
     * Valida que se pueda crear un post y retorne la respuesta correspondiente
     *
     * @throws Exception
     */
    @Test
    @DisplayName("Test creacion de post controlador")
    void createPostWithNotFoundUserIntegrationTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Arrange


        //Creacion de un post y producto para el test

        ProductRequestDTO producto = new ProductRequestDTO(1, "Producto 1", "hogar", "samsung", "rojo", "nmdfiodsf");

        PostCreateDTO Post = new PostCreateDTO(11, producto
                , LocalDate.now(), 1, 20.0);

        String payloadPost = writer.writeValueAsString(Post);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadPost);

        //Act & Assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        jsonPath("$.name").value("NOT FOUND USER"),
                        jsonPath("$.message").value("El usuario no fue encontrado"));

    }


    /**
            * Valida que se pueda crear un post y retorne la respuesta correspondiente
     *
             * @throws Exception
     */
    @Test
    @DisplayName("Test creacion de post controlador")
    void createPostWithNotFoundCategoryIntegrationTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Arrange


        //Creacion de un post y producto para el test

        ProductRequestDTO producto = new ProductRequestDTO(1, "Producto 1", "hogar", "samsung", "rojo", "nmdfiodsf");

        PostCreateDTO Post = new PostCreateDTO(1, producto
                , LocalDate.now(), 10, 20.0);

        String payloadPost = writer.writeValueAsString(Post);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadPost);

        //Act & Assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        jsonPath("$.name").value("NOT FOUND CATEGORY"),
                        jsonPath("$.message").value("La categoría no fue encontrado"));

    }

    /**
     * Valida que se pueda crear un post y retorne la respuesta correspondiente
     *
     * @throws Exception
     */
    @Test
    @DisplayName("Test creacion de post controlador")
    void createPostWithInvalidDateCategoryIntegrationTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Arrange


        //Creacion de un post y producto para el test

        ProductRequestDTO producto = new ProductRequestDTO(1, "Producto 1", "hogar", "samsung", "rojo", "nmdfiodsf");

        PostCreateDTO Post = new PostCreateDTO(1, producto
                , LocalDate.now(), 1, 20.0);

        String payloadPost = writer.writeValueAsString(Post);
        payloadPost = payloadPost.replace("09-05-2022", "09-6-2022");

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadPost);

        //Act & Assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        jsonPath("$.name").value("FAILED TO DESERIALIZE"),
                        jsonPath("$.message").value("Text '09-6-2022' could not be parsed at index 3"));

    }

    /**
     * Valida que se pueda crear un post y retorne la respuesta correspondiente
     *
     * @throws Exception
     */
    @Test
    @DisplayName("Test creacion de post controlador")
    void getFollowedProducts() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Arrange
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2);
        mockMvc.perform(request);

        //Creacion de un post y producto para el test
        ProductRequestDTO producto = new ProductRequestDTO(1, "Producto 1", "hogar", "samsung", "rojo", "nmdfiodsf");

        PostCreateDTO Post = new PostCreateDTO(2, producto
                , LocalDate.now(), 1, 20.0);

        String payloadPost = writer.writeValueAsString(Post);
        request = MockMvcRequestBuilders.post("/products/post/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadPost);
        mockMvc.perform(request);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        //Request
        request = MockMvcRequestBuilders.get("/products/followed/{client_id}/list", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadPost);

        //Act & Assert
        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        jsonPath("$.user_id").value(1),
                        jsonPath("$.posts", Matchers.hasSize(1)));

    }

}
