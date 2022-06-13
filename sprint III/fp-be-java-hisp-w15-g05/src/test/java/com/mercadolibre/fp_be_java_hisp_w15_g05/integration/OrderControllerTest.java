package com.mercadolibre.fp_be_java_hisp_w15_g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.ReqSavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.UserRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.SavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.UserResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.PurchaseOrderFactory;
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
public class OrderControllerTest extends IntegrationTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    MockMvc mockMvc;

    @Test
    void postOk() throws Exception {
        // Arrange
        String jwt = getBuyer2UserToken();
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())//Convertir la fecha
                .writer();

        SavePurchaseOrderDTO savePurchaseOrderDTO = PurchaseOrderFactory.getSavePOdto();
        String resJson = writer.writeValueAsString(savePurchaseOrderDTO);
        //lo que le envio
        ReqSavePurchaseOrderDTO postDTO = PurchaseOrderFactory.getsavePurchaseOrderIntegration();

        // EXPECTED
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(resJson);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders
                        .post("/api/v1/fresh-products/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO))
                        .header("Authorization",jwt);

        //act & assert
        mockMvc
                .perform(req)
                .andExpectAll(expectedStatus,expectedJson);
    }

    @Test
    void postNot() throws Exception {
        String jwt = getBuyer2UserToken();

        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())//Convertir la fecha
                .writer();

        //lo que le envio
        ReqSavePurchaseOrderDTO postDTO = PurchaseOrderFactory.getsavePurchaseOrderInvalidProduct();

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders
                        .post("/api/v1/fresh-products/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO))
                        .header("Authorization",jwt);

        //act & assert
        mockMvc
                .perform(req)
                .andExpectAll(expectedStatus);
    }

    @Test
    void modifyOk() throws Exception {
        String jwt = getBuyer2UserToken();

        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())//Convertir la fecha
                .writer();

        SavePurchaseOrderDTO savePurchaseOrderDTO = PurchaseOrderFactory.getSavePOdto();
        String resJson = writer.writeValueAsString(savePurchaseOrderDTO);
        //lo que le envio
        ReqSavePurchaseOrderDTO postDTO = PurchaseOrderFactory.getsavePurchaseOrderIntegration();

        // EXPECTED
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(resJson);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder req =
                MockMvcRequestBuilders
                        .put("/api/v1/fresh-products/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO))
                        .header("Authorization",jwt);

        //act & assert
        mockMvc
                .perform(req)
                .andExpectAll(expectedStatus,expectedJson);
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
