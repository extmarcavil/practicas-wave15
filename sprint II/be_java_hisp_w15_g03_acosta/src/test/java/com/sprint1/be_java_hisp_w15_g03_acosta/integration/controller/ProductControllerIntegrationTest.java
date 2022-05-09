package com.sprint1.be_java_hisp_w15_g03_acosta.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.Seller;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.User;
import com.sprint1.be_java_hisp_w15_g03_acosta.repository.MeliRepository;
import com.sprint1.be_java_hisp_w15_g03_acosta.util.PersonFactor;
import com.sprint1.be_java_hisp_w15_g03_acosta.util.PublicationFactor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

/**
 * Test de integracion de ProductController
 */

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    static MeliRepository meliRepository = new MeliRepository();

    List<User> users;
    List<Seller> sellers;
    List<PublicationDTO> publications;
    ObjectWriter writer;

    @BeforeEach
    public void setUp(){
        this.writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer();

        users = PersonFactor.users();
        sellers = PersonFactor.sellers();
        publications = PublicationFactor.publication();
        meliRepository.loadDataTest(sellers, users);

    }

    //Reseteo de datos en Repositorio para que los datos no se carguen nuevamente en cada BeforeEach
    @AfterEach
    public void resetSetUp(){
        meliRepository.resetDataTest(sellers, users);
    }


    //Test de Integracion de US-0005
    @Test
    @DisplayName("Guardar publicacion correctamente")
    void savePublicationTestOk() throws Exception {
        // Arrange

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        String publication = writer.writeValueAsString(publications.get(0));

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // act & assert
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/products/post").contentType(MediaType.APPLICATION_JSON).content(publication))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    //Test de Integracion de US-0005
    @Test
    @DisplayName("Guardar publicacion con ID de usuario incorrecto")
    void savePublicationTestIncorrect() throws Exception {
        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        String publication = writer.writeValueAsString(publications.get(2));

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        // act & assert
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/products/post").contentType(MediaType.APPLICATION_JSON).content(publication))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }


}
