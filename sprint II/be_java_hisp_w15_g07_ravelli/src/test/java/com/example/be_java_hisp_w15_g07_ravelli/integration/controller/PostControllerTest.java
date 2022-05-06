package com.example.be_java_hisp_w15_g07_ravelli.integration.controller;

import com.example.be_java_hisp_w15_g07_ravelli.dto.request.NewPostDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.request.ProductDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.PostDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07_ravelli.model.Post;
import com.example.be_java_hisp_w15_g07_ravelli.model.Product;
import com.example.be_java_hisp_w15_g07_ravelli.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    //TODOS SON BONUS

    @Autowired
    private MockMvc mockMvc;
    static private ObjectWriter objectMapper;

    @BeforeAll
    static void setUp() {
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @AfterEach
    void doAfter(){
        // Volver a iniciar la base de datos luego de cada tests para no tener datos modificados.
        // Lo ideal seria tener una BD segun tests o produccion, pero por cuestiones de tiempo se adopto esta decision.
        UserRepository.initDatabase();
    }

    @Test
    @DisplayName("POST /products/post: response OK")
    void newPostOK() throws Exception {
        //arrange
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        ProductDTO productDTO = new ProductDTO(1, "Prueba", "TestType", "TestBand", "Red", "Test notes");
        NewPostDTO postDTO = new NewPostDTO(1, LocalDate.now(), productDTO, 1, 100d );

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpectAll(
                        statusOk
                )
                .andReturn();
    }

    @Test
    @DisplayName("POST /products/post: response bad request - invalid arguments")
    void newPostInvalidArguments() throws Exception {
        //arrange
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        ProductDTO productDTO = new ProductDTO(-1, "Prueba@", "TestType@", "TestBand@", "Red@", "Test notes@");
        NewPostDTO postDTO = new NewPostDTO(-1, LocalDate.now(), productDTO, 1, 20000000d );

        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);;

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpectAll(
                        statusBadRequest,
                        MockMvcResultMatchers.jsonPath("$.errors.length()").value(8)
                )
                .andReturn();
    }

    @Test
    @DisplayName("POST /products/post: response 404")
    void newPostNotFound() throws Exception {
        //arrange
        // ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusNotFound = MockMvcResultMatchers.status().isNotFound();

        ProductDTO productDTO = new ProductDTO(1, "Prueba", "TestType", "TestBand", "Red", "Test notes");
        NewPostDTO postDTO = new NewPostDTO(100, LocalDate.now(), productDTO, 1, 100d );

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpectAll(
                        statusNotFound
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /products/followed/{userId}/list response OK")
    void getPostsDefault() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        //creo el resultado esperado
        ModelMapper modelMapper = new ModelMapper();

        UserFollowedPostsDTO result = new UserFollowedPostsDTO();
        result.setUserID(1);

        Product product = new Product(11, "Seca ropas", "Electrodomesticos", "Samsung", "Negro", "");
        Post post = new Post(3, LocalDate.now().minusDays(13), product, 2, 100000d);
        PostDTO postDTO1 = modelMapper.map(post, PostDTO.class);

        product = new Product(10, "Lavarropa", "Electrodomesticos", "Samsung", "Negro", "");
        post = new Post(3, LocalDate.now(), product, 2, 100000d);
        PostDTO postDTO2 = modelMapper.map(post, PostDTO.class);
        result.setPosts(List.of(postDTO1, postDTO2));
        ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(result));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "name_asc");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk,
                        content
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /products/followed/{userId}/list response OK - order ascendant")
    void getPostsOrderDateAsc() throws Exception {
        //arrange
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        /*
            ModelMapper modelMapper = new ModelMapper();

            UserFollowedPostsDTO result = new UserFollowedPostsDTO();
            result.setUserID(1);

            Product product = new Product(11, "Seca ropas", "Electrodomesticos", "Samsung", "Negro", "");
            Post post = new Post(3, LocalDate.now().minusDays(13), product, 2, 100000d);
            //ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
            PostDTO postDTO1 = modelMapper.map(post, PostDTO.class);

            product = new Product(10, "Lavarropa", "Electrodomesticos", "Samsung", "Negro", "");
            post = new Post(3, LocalDate.now(), product, 2, 100000d);
            PostDTO postDTO2 = modelMapper.map(post, PostDTO.class);
            result.setPosts(List.of(postDTO1, postDTO2));
         */

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "date_asc");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk
                )
                .andReturn();

        //Obtengo el body de la respuesta para comparar el orden ya que jsonPath() no compara el orden
        UserFollowedPostsDTO responseBody = mapper.readValue(mvcResult.getResponse().getContentAsString(), UserFollowedPostsDTO.class);
        assertEquals(responseBody.getPosts().size(), 2);
        for (PostDTO p: responseBody.getPosts()) {
            assertTrue(p.getDate().isAfter(twoWeeksAgo));
        }
        // assertEquals(result, responseBody);
        assertTrue(responseBody.getPosts().get(0).getDate().isBefore(responseBody.getPosts().get(1).getDate()));
    }

    @Test
    @DisplayName("GET /products/followed/{userId}/list response OK - order descendant")
    void getPostsOrderDateDesc() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();

        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        /*
            ModelMapper modelMapper = new ModelMapper();
            UserFollowedPostsDTO result = new UserFollowedPostsDTO();
            result.setUserID(1);

            Product product = new Product(11, "Seca ropas", "Electrodomesticos", "Samsung", "Negro", "");
            Post post = new Post(3, LocalDate.now().minusDays(13), product, 2, 100000d);
            //ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
            PostDTO postDTO1 = modelMapper.map(post, PostDTO.class);

            product = new Product(10, "Lavarropa", "Electrodomesticos", "Samsung", "Negro", "");
            post = new Post(3, LocalDate.now(), product, 2, 100000d);
            PostDTO postDTO2 = modelMapper.map(post, PostDTO.class);
            result.setPosts(List.of(postDTO2, postDTO1));
            ResultMatcher content = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(result));
        */

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "date_desc");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                .params(params))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusOk
                )
                .andReturn();
        //Obtengo el body de la respuesta para comparar el orden ya que jsonPath() no compara el orden
        UserFollowedPostsDTO responseBody = mapper.readValue(mvcResult.getResponse().getContentAsString(), UserFollowedPostsDTO.class);

        assertEquals(responseBody.getPosts().size(), 2);
        for (PostDTO p: responseBody.getPosts()) {
            assertTrue(p.getDate().isAfter(twoWeeksAgo));
        }
        //assertEquals(responseBody, result);
        assertTrue(responseBody.getPosts().get(0).getDate().isAfter(responseBody.getPosts().get(1).getDate()));
    }

    @Test
    @DisplayName("GET /products/followed/{userId}/list: response not found")
    void getPostsUserNotFound() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusNotFound = MockMvcResultMatchers.status().isNotFound();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", 100))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusNotFound
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /products/followed/{userId}/list response bad request - invalid param")
    void getPostsInvalidParam() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("order", "error");
        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                            .params(params))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusBadRequest
                )
                .andReturn();
    }

    @Test
    @DisplayName("GET /products/followed/{userId}/list response bad request - negative id")
    void getPostsNegativeId() throws Exception {
        //arrange
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher statusBadRequest = MockMvcResultMatchers.status().isBadRequest();

        //act

        //assert
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", -1))
                .andDo(print())
                .andExpectAll(
                        contentType,
                        statusBadRequest
                )
                .andReturn();
    }
}
