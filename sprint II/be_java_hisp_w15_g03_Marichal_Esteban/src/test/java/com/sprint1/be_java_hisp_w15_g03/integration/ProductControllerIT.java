package com.sprint1.be_java_hisp_w15_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.CategoryNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.ProductDuplicatedException;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import com.sprint1.be_java_hisp_w15_g03.utils.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MeliRepository meliRepository;

    @BeforeEach
    void setup() {
        meliRepository.loadDataTest(TestUtilsGenerator.dataToTest());
    }

    @AfterEach
    void after() {
        meliRepository.removeDataTest(TestUtilsGenerator.dataToTest());
    }


    @Test
    @DisplayName("Verificar crear una publicación correctamente.")
    void savePublicationOk() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        ProductDTO productDTO = new ProductDTO(1, "Mesa", "Roble", "Buena", "Verde", "con detalles");
        PublicationDTO publicationDTO = new PublicationDTO(1, LocalDate.now(), productDTO, 2, 300.0);

        String payload = writer.writeValueAsString(publicationDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Verificar crear una publicación con fallo en las validaciones.")
    void savePublicationMethodArgumentNotValidException() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        ProductDTO productDTO = new ProductDTO(1, "Mesa", null, "Buena", "Verde", "con detalles");
        PublicationDTO publicationDTO = new PublicationDTO(-1, LocalDate.now(), productDTO, 2, 300.0);

        String payload = writer.writeValueAsString(publicationDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException)
                 );
    }

    @Test
    @DisplayName("Verificar crear una publicación con una categoría inexistente.")
    void savePublicationCategoryNotFoundException() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        ProductDTO productDTO = new ProductDTO(1, "Mesa", "Roble", "Buena", "Verde", "con detalles");
        PublicationDTO publicationDTO = new PublicationDTO(1, LocalDate.now(), productDTO, 100, 300.0);

        String payload = writer.writeValueAsString(publicationDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof CategoryNotFoundException)
                );
    }

    @Test
    @DisplayName("Verificar crear una publicación con un usuario inexistente.")
    void savePublicationPersonNotFoundException() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        ProductDTO productDTO = new ProductDTO(1, "Mesa", "Roble", "Buena", "Verde", "con detalles");
        PublicationDTO publicationDTO = new PublicationDTO(60, LocalDate.now(), productDTO, 2, 300.0);

        String payload = writer.writeValueAsString(publicationDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)
                );
    }

    @Test
    @DisplayName("Verificar crear una publicación con un producto existente invalido.")
    void savePublicationProductDuplicatedException() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        ProductDTO productDTO = new ProductDTO(50, "Mesa", "Chapa", "Mala", "Gris", "0km");
        PublicationDTO publicationDTO = new PublicationDTO(50, LocalDate.now(), productDTO, 2, 200.0);

        String payload = writer.writeValueAsString(publicationDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isConflict();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof ProductDuplicatedException)
                );
    }

    @Test
    @DisplayName("Verificar que al crear una publicación la url contenga un body.")
    void savePublicationHttpMessageNotReadableException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof HttpMessageNotReadableException)
                );
    }

    @Test
    @DisplayName("Verificar obtener lista de las ultimas publicaciones correctamente.")
    void getLastPublicationsOk() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 55)
                .queryParam("order", "date_asc")
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        MvcResult result =mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        SellerPListDTO sellerPListDTO = objectMapper.readValue(result.getResponse().getContentAsString(), SellerPListDTO.class);
        //El usuario Esteban sigue a los vendedores (Antel, Movistar y Claro) y en total de las ultimas dos semanas hay 4 publicaciones.
        Assertions.assertEquals(sellerPListDTO.getPosts().size(), 4);
    }

    @Test
    @DisplayName("El id debe ser positivo.")
    void getLastPublicationsConstraintViolationException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", -1)
                .queryParam("order", "date_asc")
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof ConstraintViolationException)
                );
    }

    @Test
    @DisplayName("Verificar obtener lista de las ultimas publicaciones con un usuario inexistente.")
    void getLastPublicationsPersonNotFoundException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 60)
                .queryParam("order", "date_asc")
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)
                );
    }

    @Test
    @DisplayName("Verificar obtener lista de las ultimas publicaciones con un orden invalido.")
    void getLastPublicationsOrderInvalidException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 1)
                .queryParam("order", "no_existe")
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof OrderInvalidException)
                );
    }

}
