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

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        ResultMatcher expectedStatus = status()
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
        String[] errsArr = {
                "La marca debe contener solo letras y numeros",
                "El color debe contener solo letras y numeros",
                "La nota debe contener solo letras y numeros",
                "El nombre debe contener solo letras y numeros",
                "El tipo debe contener solo letras y numeros"
        };
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedStatus = status()
                .isBadRequest();
        ResultMatcher expectedSuccess = MockMvcResultMatchers
                .jsonPath("$.success").value(false);
        ResultMatcher expectedBrandErr = MockMvcResultMatchers
                .jsonPath("$['errors']['detail.brand']").value(errsArr[0]);
        ResultMatcher expectedColorErr = MockMvcResultMatchers
                .jsonPath("$['errors']['detail.color']").value(errsArr[1]);
        ResultMatcher expectedNotesErr = MockMvcResultMatchers
                .jsonPath("$['errors']['detail.notes']").value(errsArr[2]);
        ResultMatcher expectedProductNameErr = MockMvcResultMatchers
                .jsonPath("$['errors']['detail.productName']").value(errsArr[3]);
        ResultMatcher expectedTypeErr = MockMvcResultMatchers
                .jsonPath("$['errors']['detail.type']").value(errsArr[4]);

        // Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedSuccess,
                        expectedBrandErr,
                        expectedProductNameErr,
                        expectedColorErr,
                        expectedTypeErr,
                        expectedNotesErr
                );
    }

    @Test
    public void test_asd() throws Exception {
        Long id = 19L;

        ResultMatcher expectedStatus = status()
                .isNotFound();

        ResultMatcher expectedMessage = MockMvcResultMatchers
                .jsonPath("$.path").value("false");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{seller_id}/followers/count", id);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().reason(containsString("The user does not exists")));
    }
}
