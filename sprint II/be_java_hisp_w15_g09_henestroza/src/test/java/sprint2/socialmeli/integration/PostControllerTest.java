package sprint2.socialmeli.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
import org.springframework.web.bind.MethodArgumentNotValidException;
import sprint2.socialmeli.dto.ProductDTO;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;

import java.time.LocalDate;
import java.util.Objects;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Create post success")
    public void testCreatePostSuccessful() throws Exception {
        // Arrange
        String payload = getPayload(true);
        ResultMatcher okStatus = MockMvcResultMatchers.status().isOk();
        // Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                                                                        .contentType(MediaType.APPLICATION_JSON)
                                                                        .content(payload);
        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(okStatus);
    }

    @Test
    @DisplayName("Create post failure")
    public void testCreatePostThrowsExceptionWithInvalidPayload() throws Exception {
        // Arrange
        String payload = getPayload(false);
        ResultMatcher badRequestStatus = MockMvcResultMatchers.status().isBadRequest();
        // Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        result -> {
                            Assertions.assertEquals(MethodArgumentNotValidException.class,
                                    Objects.requireNonNull(result.getResolvedException()).getClass());
                        },
                        badRequestStatus
                );
    }

    private String getPayload(boolean isValidPayload) throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String productName = "Silla & Accesorios"; // Nombre invalido al contener caracteres especiales
        if (isValidPayload) {
            productName = "Silla";
        }
        ProductDTO detail = new ProductDTO(2, productName, "Gamer", "Razer", "Black", "N A");
        RequestPostDTO postRequest = new RequestPostDTO(1, LocalDate.now().minusDays(4), detail, 2, 1500D);
        return writer.writeValueAsString(postRequest);
    }

}
