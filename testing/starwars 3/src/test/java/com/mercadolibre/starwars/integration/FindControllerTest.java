package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void find() throws Exception {
        String query="darth";

        String jsonExpected ="[\n" +
                "    {\n" +
                "        \"name\": \"Darth Vader\",\n" +
                "        \"hair_color\": \"none\",\n" +
                "        \"skin_color\": \"white\",\n" +
                "        \"eye_color\": \"yellow\",\n" +
                "        \"birth_year\": \"41.9BBY\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"homeworld\": \"Tatooine\",\n" +
                "        \"species\": \"Human\",\n" +
                "        \"height\": 202,\n" +
                "        \"mass\": 136\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Darth Maul\",\n" +
                "        \"hair_color\": \"none\",\n" +
                "        \"skin_color\": \"red\",\n" +
                "        \"eye_color\": \"yellow\",\n" +
                "        \"birth_year\": \"54BBY\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"homeworld\": \"Dathomir\",\n" +
                "        \"species\": \"Zabrak\",\n" +
                "        \"height\": 175,\n" +
                "        \"mass\": 80\n" +
                "    }\n" +
                "]";

        MockHttpServletRequestBuilder req= MockMvcRequestBuilders.get("/{query}",query);

        ResultMatcher status = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType=MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher body = MockMvcResultMatchers.content().json(jsonExpected);
        mockMvc.perform(req)
                .andExpectAll(
                        status,
                        contentType,
                        body

                );

    }
}
