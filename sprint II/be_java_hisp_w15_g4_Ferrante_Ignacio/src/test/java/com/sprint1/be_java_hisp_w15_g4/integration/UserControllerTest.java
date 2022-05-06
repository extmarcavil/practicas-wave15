package com.sprint1.be_java_hisp_w15_g4.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g4.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.ErrorDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.IdNotPositiveErrorDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.ValidationErrorDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Solicitud de seguimiento entre usuarios existentes correcta")
    void followUserTestOK() throws Exception {
        mockMvc
            .perform(post("/users/{userId}/follow/{userIdToFollow}", 3, 2))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Solicitud de seguimiento entre usuarios iguales devuelve error de mismo id")
    void followSameUserBreaks() throws Exception {
        ObjectWriter writer =  new ObjectMapper().writer();

        // arrange
        String listJson = writer.writeValueAsString(new ErrorDTO("Los id deben ser diferentes: 1", HttpStatus.CONFLICT));

        // act & assert
        mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}", 1,1))
                .andExpectAll(
                        MockMvcResultMatchers.status().isConflict(),
                        MockMvcResultMatchers.content().json(listJson),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    @DisplayName("Solicitud de seguimiento entre usuarios no existentes devuelve error de no existente")
    void followUserNotExistentBreaks() throws Exception {
        ObjectWriter writer =  new ObjectMapper().writer();

        // arrange
        String listJson = writer.writeValueAsString(new ErrorDTO("No se ha encontrado el usuario: 5", HttpStatus.NOT_FOUND));

        // act & assert
        mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}", 1,5))
                .andExpectAll(
                        MockMvcResultMatchers.status().isNotFound(),
                        MockMvcResultMatchers.content().json(listJson),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    @DisplayName("Solicitud de seguimiento entre usuarios que ya se seguian devuelve error")
    void followUserAlreadyFollowingBreaks() throws Exception {
        ObjectWriter writer =  new ObjectMapper().writer();

        // arrange
        String listJson = writer.writeValueAsString(new ErrorDTO("El usuario 1 ya sigue al usuario 2", HttpStatus.CONFLICT));

        // act & assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,2));

        mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}", 1,2))
                .andExpectAll(
                        MockMvcResultMatchers.status().isConflict(),
                        MockMvcResultMatchers.content().json(listJson),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    @DisplayName("Solicitud de seguimiento con ids invalidos devuelve error")
    void followBadIdBreaks() throws Exception {
        ObjectWriter writer =  new ObjectMapper().writer();

        // arrange
        Map<String, String> errors = new HashMap<>();
        errors.put("userId","El id debe ser mayor a cero.");
        errors.put("userIdToFollow","El id debe ser mayor a cero.");
        String listJson = writer.writeValueAsString(new IdNotPositiveErrorDTO(HttpStatus.BAD_REQUEST, errors));

        // act & assert
        mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}", -1,-2))
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.content().json(listJson),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    @DisplayName("Solicitud de dejar de seguir entre usuarios existentes correcta")
    void unFollowUserTestOK() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2));

        mockMvc
                .perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Solicitud de dejar de seguir entre usuarios que no se siguen devuelve error")
    void ccc() throws Exception {
        ObjectWriter writer =  new ObjectMapper().writer();

        // arrange
        String listJson = writer.writeValueAsString(new ErrorDTO("No estas siguiendo al usuario: 2", HttpStatus.BAD_REQUEST));

        // act & assert
        mockMvc
                .perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 4,2))
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.content().json(listJson),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    @DisplayName("Solicitud de posteo funciona correctamente con un post valido")
    void postProductTestOk() throws Exception {
        ObjectWriter writer =  new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        // arrange
        String postJason = writer
                                .writeValueAsString(getGoodPost())
                                .replace("[2022,5,2]", "\"02-05-2022\"");

        // act & assert
        mockMvc
                .perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postJason))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Solicitud de posteos devuelve error de validacion")
    void badPostBadInput() throws Exception {
        ObjectWriter writer =  new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        // arrange
        String postJason = writer
                .writeValueAsString(getGoodPost())
                .replace("[2022,5,2]", "\"02-05-2022\"");

        Map<String, List<String>> errors = new HashMap<>();
        errors.put("user_id",Arrays.asList("El id debe ser mayor a cero."));
        errors.put("detail.color", Arrays.asList("La longitud no puede superar los 15 caracteres.","El campo no puede poseer caracteres especiales."));
        String listJson = writer.writeValueAsString(new ValidationErrorDTO(HttpStatus.BAD_REQUEST, errors));

        // act & assert
        mockMvc
                .perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postJason))
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.content().json(listJson),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    private PostDTO getGoodPost() {
        ProductDTO product = new ProductDTO();
        product.setProduct_id(1);
        product.setProduct_name("name");
        product.setType("type");
        product.setBrand("brand");
        product.setColor("color llllllllll");
        product.setNotes("notes");

        PostDTO post = new PostDTO();
        post.setUser_id(-1);
        post.setPost_id(1);
        post.setDate(LocalDate.of(2022,5,2));
        post.setDetail(product);
        post.setCategory(1);
        post.setPrice(1.55);

        return post;
    }
}
