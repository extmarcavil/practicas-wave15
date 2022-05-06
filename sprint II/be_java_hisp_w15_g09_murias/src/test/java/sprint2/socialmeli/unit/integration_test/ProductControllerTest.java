package sprint2.socialmeli.unit.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
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
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;
    static private ObjectWriter writer;

    @BeforeAll
    static void setUp(){
        writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer();
    }


    // T-0012 BONUS Verificar que un posteo se haga correctamente
    @Test
    public void test12CheckPostOk() throws Exception{
        ProductDTO productDTO = new ProductDTO(123, "MacBookPro 13", "Notebook", "Apple", "Grey", "Prueba");
        RequestPostDTO post = new RequestPostDTO(1, LocalDate.now(), productDTO, 5, 25000D);
        String postAux = writer.writeValueAsString(post);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .content(postAux)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // T-0012 BONUS Verificar que un posteo no se haga y lance excepción.
    @Test
    public void test12CheckPostNotOk() throws Exception{
        ProductDTO productDTO = new ProductDTO(123, "nacBookPro 13", "Note//$&b", "Apple", "Grey", "Prueba");
        RequestPostDTO post = new RequestPostDTO(1, LocalDate.now(), productDTO, 5, 25000D);
        String postAux = writer.writeValueAsString(post);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .content(postAux)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
