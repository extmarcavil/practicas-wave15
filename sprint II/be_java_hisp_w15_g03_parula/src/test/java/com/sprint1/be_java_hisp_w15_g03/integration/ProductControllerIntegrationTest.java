package com.sprint1.be_java_hisp_w15_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.ErrorValidationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.ProductDuplicatedException;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import com.sprint1.be_java_hisp_w15_g03.utils.DataUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    static MeliRepository meliRepository;
    static DataUtil datos;

    @BeforeAll
    static void setup() {
        datos = new DataUtil();
        meliRepository.loadDataTest(datos.getUsers(),datos.getSellers(),datos.getProducts());
    }

    @AfterAll
    static void setoff(){

        meliRepository.deleteDataTest(datos.getUsers(),datos.getSellers());
    }

    @Test
    @DisplayName("Obtengo las ultimas publicaciones de un usuario")
    void getLastPublications() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 5000);
        //act & assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        SellerPListDTO sellerList = objectMapper.readValue(response.getResponse().getContentAsString(), SellerPListDTO.class);
        assertAll(
                ()->assertEquals(5000, sellerList.getUserId()),
                ()->assertEquals(4,sellerList.getPosts().size()),
                ()->assertEquals(0,(sellerList.getPosts().stream().filter(x -> x.getDetail().getProductId()==5003).collect(Collectors.toList()).size())),
                ()->assertEquals(1,(sellerList.getPosts().stream().filter(x -> x.getDetail().getProductId()==5002).collect(Collectors.toList()).size())),
                ()->assertEquals(2,(sellerList.getPosts().stream().filter(x -> x.getDetail().getProductId()==5000).collect(Collectors.toList()).size()))


        );


    }


    @Test
    @DisplayName("Realizo el get publicaciones con usuario que no sigue vendedores")
    void getPublicacionesSinSeguidores() throws Exception {
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 5004);
        //act & assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        SellerPListDTO sellerList = objectMapper.readValue(response.getResponse().getContentAsString(), SellerPListDTO.class);
        assertAll(
                ()->assertEquals(5004, sellerList.getUserId()),
                ()->assertEquals(0,sellerList.getPosts().size())
                );
    }

    @Test
    @DisplayName("Realizo el get publicaciones con usuario inexistente")
    void getPublicacionesInexistente() throws Exception {

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list",5999).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        (result -> assertTrue(result.getResolvedException() instanceof PersonNotFoundException))
                );

    }
    @Test
    @DisplayName("Realizo el post publicaciones agregando una nueva publicacion")
    void postPublicaciones() throws Exception {
        //Arrange
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        ProductDTO pr4 = new ProductDTO(5100, "Producto post", "Tipo post", "Marca post", "Color post","Notes");
        PublicationDTO publication = new PublicationDTO(5004, LocalDate.now(),pr4, 1,10.0);
        String publicationPayload = writer.writeValueAsString(publication);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(publicationPayload);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);

    }

    @Test
    @DisplayName("Realizo el post publicaciones con un producto ya existente")
    void postPublicacionesProductoExistente() throws Exception {
        //Arrange
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        ProductDTO pr4 = new ProductDTO(5000,"NombreProductoUno","TipoUno",
                "MarcaUno", "Color uno", "Notas del producto 1");
        PublicationDTO publication = new PublicationDTO(5000, LocalDate.now(),pr4, 1,10.0);
        String publicationPayload = writer.writeValueAsString(publication);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(publicationPayload);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);

    }

    @Test
    @DisplayName("Realizo el post publicaciones muchas validaciones incorrectas")
    void postPublicacionesValidacionesInvalidas() throws Exception {
        //Arrange
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        ProductDTO pr4 = new ProductDTO(0,"NombreProducto Uno con mas de cuarenta caracteres para que falle","quincecaracteres o mas",
                "MarcaUno", "Color uno", "Notas del producto 1");
        PublicationDTO publication = new PublicationDTO(5000, LocalDate.now(),pr4, 1,10.0);
        String publicationPayload = writer.writeValueAsString(publication);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(publicationPayload);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        (result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                        )
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        ErrorValidationDTO validationResponse = objectMapper.readValue(response.getResponse().getContentAsString(), ErrorValidationDTO.class);

        assertEquals("Some Input are Invalids", validationResponse.getMessage());
        assertEquals(3, validationResponse.getErrors().size());



    }

    @Test
    @DisplayName("Realizo el post publicaciones con un producto con id duplicado: Error")
    void postPublicacionesProductoDuplicado() throws Exception {
        //Arrange
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        ProductDTO pr4 = new ProductDTO(5000,"NombreProducto Duplicado","vali",
                "Marca Duplicada", "Color Duplicado", "Notas del producto Duplicado");
        PublicationDTO publication = new PublicationDTO(5000, LocalDate.now(),pr4, 1,10.0);
        String publicationPayload = writer.writeValueAsString(publication);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isConflict();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(publicationPayload);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        (result -> Assertions.assertTrue(result.getResolvedException() instanceof ProductDuplicatedException)),
                        (result -> Assertions.assertEquals("El producto existente no concuerda con los datos enviados.", result.getResolvedException().getMessage()))
                );

    }


}
