package com.mercadolibre.fp_be_java_hisp_w15_g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.UserRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.UserResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest extends IntegrationTest{
    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getListNotOk() throws Exception {
        // Arrange
        String jwt = getBuyer2UserToken();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders
                        .get("/api/v1/fresh-products/list?category=3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",jwt);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        //act & assert
        mockMvc
                .perform(req)
                .andExpectAll(expectedStatus);
    }

    public String getBuyer2UserToken() throws Exception {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUser_name("buyer");
        userRequestDTO.setPassword("123");

        String json = objectMapper.writeValueAsString(userRequestDTO);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/api/v1/sign-in")
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        return objectMapper.readValue(result.getResponse().getContentAsString(), UserResponseDTO.class).getToken();
    }
}
