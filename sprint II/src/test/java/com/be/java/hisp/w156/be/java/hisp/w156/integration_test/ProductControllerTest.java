package com.be.java.hisp.w156.be.java.hisp.w156.integration_test;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Testing del 2 last weeks")
    void test1() throws Exception{
        //arrange

        LocalDate date = LocalDate.parse(
                LocalDate.now().toString(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
        );

        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        ResponsePostDTO responsePostDTO = new ResponsePostDTO(1, date, product, "150", 100.50 );

        List<ResponsePostDTO> list = new ArrayList<>();
        list.add(responsePostDTO);

        RecentlyPostDTO recentlyPostDTO = new RecentlyPostDTO(1, list);

        ObjectWriter writer = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .registerModule(new JavaTimeModule())
                .writer();



        String listJson = writer.writeValueAsString(recentlyPostDTO);

        System.out.println(listJson);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = content().json(listJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1 )
                                                                        .param("order", "date_asc");


    mockMvc
            .perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(
                    expectedStatus,
                    expectedJson,
                    expectedContentType
            );
    }


}
