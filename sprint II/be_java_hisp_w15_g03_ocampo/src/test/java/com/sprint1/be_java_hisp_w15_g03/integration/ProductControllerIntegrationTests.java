package com.sprint1.be_java_hisp_w15_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    //Inicializacion de repositorio de pruebas y declaracion de variables
    static IMeliRepository meliRepository = new MeliRepository();

    private static ObjectWriter writer;

    private static PublicationDTO publicationDTO;
    private static Product product;


    //Inicializacion de variables y seteo del repositorio con los datos necesarios para los tests
    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        //Variables para testValidSavePublication()
        ProductDTO productDTO = new ProductDTO(1, "bicicleta", "Algo", "Algo", "Algo", "Algo");
        publicationDTO = new PublicationDTO(1, LocalDate.now(), productDTO, 1, 300.0);

        //Variables y seteo para testValidGetLastPublications()
        product = new Product(2, "Estufa", "", null, null, null);
        meliRepository.savePublication(1, new Publication(1, LocalDate.now(), Category.MESA, 300.0, product, null, null));
        meliRepository.followSeller(1, 1);
    }

    @AfterAll
    public static void borrowSetUp() {
        meliRepository.unFollowSeller(1,1);
    }

    @Test
    @DisplayName("Verifica que la integracion para guardar una nueva publicacion sea correcta")
    public void testValidSavePublication() throws Exception {

        String publicationJSON = writer.writeValueAsString(publicationDTO);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(publicationJSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verifica que la integracion para obtener las ultimas publicaciones de los sellers seguidos por un user este correcta")
    public void testValidGetLastPublications() throws Exception {

        mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        jsonPath("$.userId").value(1),
                        jsonPath("$.posts.size()").value(1),
                        jsonPath("$.posts[?(@.detail" +
                                "[?(@.productId == " + product.getProductId() +
                                " && @.productName == '" + product.getProductName() + "')])]").exists()
                );
    }


}
