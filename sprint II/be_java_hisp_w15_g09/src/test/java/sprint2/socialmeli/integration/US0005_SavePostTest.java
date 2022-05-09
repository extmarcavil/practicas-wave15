package sprint2.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sprint2.socialmeli.dto.ProductDTO;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;
import sprint2.socialmeli.exceptions.ErrorDTO;

import javax.validation.Valid;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class US0005_SavePostTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectWriter writer;

    @BeforeEach
    void setUp(){
        this.writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test01CanSaveAPostCorrecltly() throws Exception {

        ProductDTO aNewProduct = new ProductDTO(1,"Silla","Mueble","Marca","Negra","Producto nuevo");

        RequestPostDTO aNewPost = new RequestPostDTO(1, LocalDate.now(),aNewProduct,1,1D);

        String newPostAsJson = this.writer.writeValueAsString(aNewPost);

        MvcResult mvcResult =
                this.mockMvc
                        .perform(post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(newPostAsJson)
                        )
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals("Creado post: 1", mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test02CantSaveAPostWithErrors() throws Exception {
        ProductDTO aBadNamedProduct = new ProductDTO(1,"","Mueble","Marca","Negra","Producto nuevo");

        RequestPostDTO aNewPost = new RequestPostDTO(1, LocalDate.now(),aBadNamedProduct,1,1D);

        String newPostAsJson = this.writer.writeValueAsString(aNewPost);

        this.mockMvc
                    .perform(post("/products/post")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(newPostAsJson)
                    )
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andReturn();
    }




}
