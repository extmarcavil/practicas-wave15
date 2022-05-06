package com.sprint1.be_java_hisp_w15_g03.unit.controller;

import ch.qos.logback.core.net.ObjectWriterFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MeliRepository meliRepository;

    @Autowired
    MockMvc mockMvc;

    PublicationDTO publicationDTO1;
    PublicationDTO publicationDTO2;
    ProductDTO productDTO1;
    ProductDTO productDTO2;

    User user1, user2, user3, user4;
    Seller seller1, seller2, seller3, seller4;



    @BeforeEach
    void setup(){
        productDTO1 = new ProductDTO(1, "Silla Gamer", "Sillas", "Ryzen" , "Black", "Silla ideal para jugar CSGO");
        productDTO2 = new ProductDTO(2, "Teclado Custom Blue MIV212", "Custom", "Gigabyte" , "Blue", "Teclado ideal para el coding");

        publicationDTO1 = new PublicationDTO(1, LocalDate.now(), productDTO1, 2, 25000.00 );
        publicationDTO2 = new PublicationDTO(2, LocalDate.now(), productDTO2, 1, 16000.00 );

        user1 = new User(20, "Facundo");
        user2 = new User(22, "Pablo");

        seller1 = new Seller(24, "Netflix");
        seller2 = new Seller(25, "Spotify");

        user3 = meliRepository.addUser(user1);
        user4 = meliRepository.addUser(user2);
        seller3 = meliRepository.addSeller(seller1);
        seller4 = meliRepository.addSeller(seller2);


    }

    @Test
    @DisplayName("Verifico guardar publicacion correctamente")
    void savePublicationTest() throws Exception {
        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        String payload = writer.writeValueAsString(publicationDTO1);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
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
    @DisplayName("Verifico obtener publicaciones")
    void getLastPublications() throws Exception {
        // Arrange

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/products/followed/{userId}/list",
                1);
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andReturn();
    }
}


