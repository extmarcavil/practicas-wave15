package com.social.media.sprgbt.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.media.sprgbt.dto.CategoryDto;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationProductControllerTest {


    @Autowired
    private MockMvc mvc;

    ObjectMapper objectMapper;

    /**
     * Method BeforeEach() del ciclo de vida
     * Para Inicializar el ObjectMapper
     */
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    /**
     * Tests Integration*
     */
    @Test
    @Order(1)
    @DisplayName("Create Product.")
    void createProductTest() throws Exception {

        mvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Data.PRODUCTDTO_TECHNOLOGY)))

                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productName").value("Macbook Pro"));


    }

    @Test
    @Order(2)
    @DisplayName("Get Product By id.")
    void getProductByIdTest() throws Exception {

        mvc.perform(get("/products/{productId}", 1)
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productName").value("Macbook Pro"));

    }

    @Test
    @Order(3)
    @DisplayName("Get All Product.")
    void getAllProductsTest() throws Exception {

        mvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }


    /**
     * Category
     */
    @Test
    @Order(4)
    @DisplayName("Create Category.")
    void createCategoryTest() throws Exception {

        mvc.perform(post("/products/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CategoryDto(8, "Home"))))

                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    @Order(5)
    @DisplayName("Get Catgory By id.")
    void getCategoryByIdTest() throws Exception {

        mvc.perform(get("/products/category/{categoryId}", 1)
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nameCategory").value("Tecnologia"));

    }

    @Test
    @Order(6)
    @DisplayName("Get All Catgorys.")
    void getAllCategory() throws Exception {

        mvc.perform(get("/products/category")
                        .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }


}