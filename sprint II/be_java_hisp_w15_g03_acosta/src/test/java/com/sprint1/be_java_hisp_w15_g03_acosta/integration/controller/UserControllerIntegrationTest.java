package com.sprint1.be_java_hisp_w15_g03_acosta.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.Seller;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.User;
import com.sprint1.be_java_hisp_w15_g03_acosta.repository.MeliRepository;
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

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    static MeliRepository meliRepository = new MeliRepository();

    User user1, user2;
    Seller seller1, seller2;

    @BeforeEach
    public void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        user1 = new User(1, "Maria");
        user2 = new User(2, "Jose");

        seller1 = new Seller(1, "Garbarino");
        seller2 = new Seller(2, "Musimundo");

        user1 = meliRepository.addUser(user1);
        seller1 = meliRepository.addSeller(seller1);
    }

    @Test
    @DisplayName("Seguir un vendedor correcto")
    public void followSellerOk() throws Exception{
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(expectedStatus);

    }



}
