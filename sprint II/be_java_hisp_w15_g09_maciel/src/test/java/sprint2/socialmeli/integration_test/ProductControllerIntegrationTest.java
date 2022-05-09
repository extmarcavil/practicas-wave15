package sprint2.socialmeli.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sprint2.socialmeli.dto.ProductDTO;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

   //T-0009
    @Test
    @DisplayName("Verificar que se cree correctamente un post")
    public void testSavePost() throws Exception{
    ObjectWriter writer =  new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .registerModule(new JavaTimeModule()) // convertir fechas
            .writer();

    ProductDTO productDTO = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red y Black", "Special Edition");
    RequestPostDTO requestPostDTO = new RequestPostDTO(2, LocalDate.parse("2022-05-03"), productDTO, 100, 1500.50);
    String requestPostDTOPayload = writer.writeValueAsString(requestPostDTO);

    mockMvc
            .perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestPostDTOPayload))
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(
                    MockMvcResultMatchers.status().isOk(),
                    MockMvcResultMatchers.content().string(Matchers.containsString("Creado post:"))
            );
    }
}
