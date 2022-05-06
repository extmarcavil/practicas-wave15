package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.integration;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.*;
import com.fasterxml.jackson.databind.ObjectWriter;
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
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_integration_createPost() throws Exception {
        // Arrange
        ObjectWriter writer = ObjectWriterFactory.create();
        PostDTO p = PostDTOFactory.createPost();
        String payload = writer.writeValueAsString(p);
        ResponseDTO expectedResponse = ResponseDTOFactory.create("Product Created!");
        String expectedPayload = writer.writeValueAsString(expectedResponse);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = MockMvcResultMatchers
                .status()
                .isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers
                .content()
                .json(expectedPayload);

        // Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedContentType, expectedJson);
    }

    @Test
    public void test_integration_createPostSadPath() throws Exception {
        // Arrange
        ObjectWriter writer = ObjectWriterFactory.create();
        PostDTO p = PostDTOFactory.createWrongPost();
        String payload = writer.writeValueAsString(p);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = MockMvcResultMatchers
                .status()
                .isBadRequest();
        ResultMatcher expectedSuccess = MockMvcResultMatchers
                .jsonPath("$.success").value(false);

        // Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedContentType, expectedSuccess);
    }
}
