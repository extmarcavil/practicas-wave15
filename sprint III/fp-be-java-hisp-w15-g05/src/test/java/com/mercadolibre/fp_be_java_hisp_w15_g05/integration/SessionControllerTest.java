package com.mercadolibre.fp_be_java_hisp_w15_g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.UserRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.InboundOrderRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SessionControllerTest extends IntegrationTest{

    @Autowired
    MockMvc mockMvc;

    static InboundOrderRepository inboundOrderRepository;
    static IWarehouseService warehouseService;
    static ISectionService sectionService;
    static IBatchService batchService;
    static SessionServiceImpl sessionService;
    static InboundOrderService service = new InboundOrderService(inboundOrderRepository, warehouseService, sectionService, batchService, sessionService);


    @Test
    public void sessionTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        UserRequestDTO userRequest = new UserRequestDTO("buyer", "123");

        String jsonUser = writer.writeValueAsString(userRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/api/v1/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUser);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        ResultActions actions = this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void invalidSessionTest() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        UserRequestDTO userRequest = new UserRequestDTO("test", "123");

        String jsonUser = writer.writeValueAsString(userRequest);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/api/v1/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUser);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        ResultActions actions = this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

}
