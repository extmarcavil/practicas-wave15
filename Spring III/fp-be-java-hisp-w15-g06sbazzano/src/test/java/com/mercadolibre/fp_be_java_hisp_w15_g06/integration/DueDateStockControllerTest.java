package com.mercadolibre.fp_be_java_hisp_w15_g06.integration;


import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DueDateStockControllerTest extends IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Testing del endpoint correspondiente al filtro de Batchs por fecha de vencimiento")
    void test1() throws Exception{

        //asset


        //request


        //

    }




}
