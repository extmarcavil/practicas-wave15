package com.sprint1.be_java_hisp_w15_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.RelationConflictException;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import com.sprint1.be_java_hisp_w15_g03.utils.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIT {

    private static ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MeliRepository meliRepository;

    @BeforeAll
    static void setupObject(){
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @BeforeEach
    void setup() {
        meliRepository.loadDataTest(TestUtilsGenerator.dataToTest());
    }

    @AfterEach
    void after() {
        meliRepository.removeDataTest(TestUtilsGenerator.dataToTest());
    }

    @Test
    @DisplayName("Seguir a un vendedor correctamente.")
    void followSeller() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 51, 51)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Seguir a un vendedor que ya se seguía.")
    void followSellerRelationConflictException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 50, 50)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof RelationConflictException)
                );
    }

    @Test
    @DisplayName("Seguir a un vendedor que no existe.")
    void followSellerPersonNotFoundException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 50, 61)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)
                );
    }

    @Test
    @DisplayName("Verificar que la cantidad de seguidores es correcta.")
    void getFollowersCount() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", 50)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                )
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        SellerCountDTO sellerCountDTO = objectMapper.readValue(result.getResponse().getContentAsString(), SellerCountDTO.class);
        //Al vendedor solo lo sigue un user Edgar id:50
        Assertions.assertEquals(sellerCountDTO.getFollowersCount(), 1);
    }

    @Test
    @DisplayName("Verificar que la cantidad de seguidores con un usuario inexistente.")
    void getFollowersCountPersonNotFoundException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", 60)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)
                );
    }

    @Test
    @DisplayName("Verificar que la lista de followers es correcta.")
    void getFollowersList() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 50)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                )
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        SellerFListDTO sellerFListDTO = objectMapper.readValue(result.getResponse().getContentAsString(), SellerFListDTO.class);
        //Edgar sigue dos vendedores : HBO y Netflix
        Assertions.assertAll(
                () -> Assertions.assertEquals(sellerFListDTO.getFollowers().size(), 1),
                () -> Assertions.assertEquals(sellerFListDTO.getUserName(), "Netflix"),
                () -> Assertions.assertEquals(sellerFListDTO.getUserId(), 50)
        );
    }

    @Test
    @DisplayName("Verificar que la lista de followed es correcta.")
    void getFollowedList() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", 50)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType
                )
                .andReturn();

        UserListDTO userListDTO = objectMapper.readValue(result.getResponse().getContentAsString(), UserListDTO.class);
        //Edgar sigue dos vendedores : HBO y Netflix
        Assertions.assertAll(
                () -> Assertions.assertEquals(userListDTO.getFollowed().size(), 2),
                () -> Assertions.assertEquals(userListDTO.getFollowed().get(0).getUserName(), "Netflix"),
                () -> Assertions.assertEquals(userListDTO.getFollowed().get(1).getUserName(), "HBO")
        );
    }

    @Test
    @DisplayName("Verificar que la cantidad de followed con un usuario inexistente.")
    void getFollowedListPersonNotFoundException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", 60)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)
                );
    }

    @Test
    @DisplayName("Dejar de seguir a un vendedor correctamente.")
    void unFollowSeller() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToUnfollow}", 51, 55)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Dejar de seguir a un vendedor que no se seguía.")
    void unFollowSellerRelationConflictException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToUnfollow}", 51, 54)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof RelationConflictException)
                );
    }

    @Test
    @DisplayName("Dejar de seguir a un vendedor que no existe.")
    void unFollowSellerPersonNotFoundException() throws Exception {
        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToUnfollow}", 50, 61)
                .contentType(MediaType.APPLICATION_JSON);

        // act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)
                );
    }

}
