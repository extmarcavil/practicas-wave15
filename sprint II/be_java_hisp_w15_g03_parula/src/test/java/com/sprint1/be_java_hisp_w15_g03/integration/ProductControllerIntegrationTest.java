package com.sprint1.be_java_hisp_w15_g03.integration;

import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import com.sprint1.be_java_hisp_w15_g03.utils.DataUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    MeliRepository meliRepository;


    @BeforeEach
    void setup() {
        DataUtil datos = new DataUtil();
        meliRepository.loadDataTest(datos.getUsers(),datos.getSellers());
    }


    @Test
    @DisplayName("Obtengo las ultimas publicaciones de un usuario")
    void getLastPublications() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        //ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        //normal
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/1/list");
        //act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );


    }
}
