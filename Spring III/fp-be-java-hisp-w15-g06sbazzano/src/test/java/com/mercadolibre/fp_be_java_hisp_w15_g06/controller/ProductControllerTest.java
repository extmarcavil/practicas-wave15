package com.mercadolibre.fp_be_java_hisp_w15_g06.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.ErrorDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void whenProductNotFoundInAnyWarehouse_thenReturnAJSONError() throws Exception {
    /*
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        // Arrange
        Long productId = 90L;
        ErrorDTO errorDTO = new ErrorDTO("ProductNotFoundInAnyWarehouseException","\"Producto con ID: \" + productId + \" no existe en ningún warehouse.\"");
        String listJson = writer.writeValueAsString(errorDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/v1/fresh-products/{idProduct}/warehouse/list", productId);

        // ACT & Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    */
    }


}
