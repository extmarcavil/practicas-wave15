package com.sprint1.be_java_hisp_w15_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sprint1.be_java_hisp_w15_g03.dto.response.ErrorDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import utils.UtilsTest;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class sprint2IntegrationTest {

    @Autowired
    MockMvc mockMVC;

    @Autowired
    MeliRepository repository;

    UtilsTest utils;

    @BeforeEach
    void setup(){
        utils = new UtilsTest();
        utils.createUsers();
        utils.createSellers();
        utils.createRelations();
        repository.loadTestData(utils.getUsers(),utils.getSellers(),utils.getProducts());
    }

    @Test
    @DisplayName("Verifico la cantidad de seguidores de un vendedor existente.")
    void getFollowersCountOk() throws Exception {

        SellerCountDTO sellerCountDTO = new SellerCountDTO();
        sellerCountDTO.setFollowersCount(1);
        sellerCountDTO.setUserId(3);
        sellerCountDTO.setUserName("Nike");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        String sellerCountDTOJson = writer.writeValueAsString(sellerCountDTO);

        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(sellerCountDTOJson);
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(get("/users/{userId}/followers/count",3))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus,expectedBody,expectedContentType);
    }

    @Test
    @DisplayName("Verifico la cantidad de seguidores de un vendendor inexistente")
    void getFollowersCountSellerNotFound() throws Exception
    {
        ErrorDTO error = new ErrorDTO("Entidad no encontrada","El vendedor con el id: 50 no existe");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedBody =   content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(get("/users/{userId}/followers/count",50))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus,expectedBody,expectedContentType);
    }

    @Test
    @DisplayName("Verifico la cantidad de seguidores de un vendendor inexistente")
    void getFollowersCountSellerZero() throws Exception
    {
        ResultMatcher expectedStatus = status().isBadRequest();

        mockMVC.perform(get("/users/{userId}/followers/count",0))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus);
    }


}
