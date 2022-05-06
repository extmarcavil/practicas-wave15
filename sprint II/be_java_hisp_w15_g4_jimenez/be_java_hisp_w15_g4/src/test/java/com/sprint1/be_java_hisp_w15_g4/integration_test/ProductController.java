package com.sprint1.be_java_hisp_w15_g4.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g4.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductController {

    @Autowired
    MockMvc mockMvc;

    @Test
    void postProduct() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        ProductDTO productDTO=new ProductDTO();
        productDTO.setProduct_id(1);
        productDTO.setProduct_name("Algo");
        productDTO.setType("Gamer");
        productDTO.setBrand("Racer");
        productDTO.setColor("RED");
        productDTO.setNotes("Algo");

        PostDTO dto = new PostDTO();
        dto.setUser_id(1);
        dto.setDate(LocalDate.of(2022,05,01));
        dto.setCategory(100);
        dto.setPrice(10000);
        dto.setDetail(productDTO);


        String json = writer.writeValueAsString(dto);

        //expected
        ResultMatcher status= MockMvcResultMatchers.status().isOk();



        MockHttpServletRequestBuilder req =   MockMvcRequestBuilders.post("/products/post")
                                                                    .contentType(MediaType.APPLICATION_JSON)
                                                                    .content(json);

        mockMvc.perform(req)
                .andExpectAll(
                        status
                );



    }

}
