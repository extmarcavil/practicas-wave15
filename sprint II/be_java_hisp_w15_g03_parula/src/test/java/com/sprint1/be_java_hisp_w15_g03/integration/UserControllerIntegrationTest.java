package com.sprint1.be_java_hisp_w15_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import com.sprint1.be_java_hisp_w15_g03.utils.DataUtil;
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

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    static MeliRepository meliRepository;
    static DataUtil datos;

    @BeforeAll
    static void setup() {
        datos = new DataUtil();
        meliRepository.loadDataTest(datos.getUsers(),datos.getSellers());
    }
    @AfterAll
    static void setoff(){
        meliRepository.deleteDataTest(datos.getUsers(),datos.getSellers());
    }


    //Test Integracion:Get followers Count: Caso OK
    @Test
    @DisplayName("Obtengo las ultimas publicaciones de un usuario:Ok")
    void getFollowersCount() throws Exception {
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",5000).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        SellerCountDTO sellerCountDTO = objectMapper.readValue(response.getResponse().getContentAsString(), SellerCountDTO.class);
        Assertions.assertEquals(3,sellerCountDTO.getFollowersCount());
    }
    //Test integracion: Get FollowersCount: Caso Borde
    @Test
    @DisplayName("Obtengo la cantidad de seguidores de un usuario:Caso borde")
    void getFollowersCountEmpty() throws Exception {
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",5003).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                      )
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        SellerCountDTO sellerCountDTO = objectMapper.readValue(response.getResponse().getContentAsString(), SellerCountDTO.class);
        Assertions.assertEquals(0,sellerCountDTO.getFollowersCount());
    }

    //Test Integracion: Get followersCount: Caso fallo
    @Test
    @DisplayName("Obtengo las ultimas publicaciones de un vendedor inexistente: PersonNotFoundException")
    void getFollowersCountInexistente() throws Exception {

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count",5999).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                    expectedStatus,
                    (result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)),
                    (result -> Assertions.assertEquals("El vendedor con el id: 5999 no existe", result.getResolvedException().getMessage()))
                );
    }

    //Test getFollowersList: Obtengo la lista de followers de un usuario
    @Test
    @DisplayName("Obtengo la lista de seguidores de un usuario:Ok")
    void getFollowersListOk() throws Exception {
        //Arrange
        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        SellerFListDTO sellerResp = datos.getFirstSellerFListDTO("");
        String expectedBody = writer.writeValueAsString(sellerResp);

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",5000).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson
                )
                .andReturn();

    }


    //Test GetFollowersList: Vacio
    @Test
    @DisplayName("Obtengo la cantidad de seguidores de un usuario:Caso borde")
    void getFollowersListEmpty() throws Exception {
        //Arrange
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",5003).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        SellerFListDTO sellerFList = objectMapper.readValue(response.getResponse().getContentAsString(), SellerFListDTO.class);
        assertAll(
                ()->assertEquals(5003, sellerFList.getUserId()),
                ()->assertEquals(0,sellerFList.getFollowers().size())

        );
    }


    //Test Get followersList:Person not found

    @Test
    @DisplayName("Obtengo la lista de seguidores de un vendedor inexistente: PersonNotFoundException")
    void getFollowersListInexistente() throws Exception {
        //Arrange
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",5999).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        (result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)),
                        (result -> Assertions.assertEquals("El vendedor con el id: 5999 no existe", result.getResolvedException().getMessage()))
                );
    }

    //Test getFollowersList: Obtengo la lista de followers de un usuario
    @Test
    @DisplayName("Obtengo la lista de seguidores de un usuario ordenado alfabeticamente:Ok")
    void getFollowersListOrdenAscOk() throws Exception {
        //Arrange
       SellerFListDTO sellerResp = datos.getFirstSellerFListDTO("asc");

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list?order={order}",5000,"name_asc").contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        SellerFListDTO sellerFListDTO = objectMapper.readValue(response.getResponse().getContentAsString(), SellerFListDTO.class);
        List<PersonDTO> followers = sellerFListDTO.getFollowers();
        assertAll(
                ()->assertEquals(3,followers.size()),
                ()->assertEquals(followers.get(0).getUserName(),sellerResp.getFollowers().get(0).getUserName()),
                ()->assertEquals(followers.get(1).getUserName(),sellerResp.getFollowers().get(1).getUserName()),
                ()->assertEquals(followers.get(2).getUserName(),sellerResp.getFollowers().get(2).getUserName())

                );

    }

    //Test getFollowersList: Obtengo la lista de followers de un usuario
    @Test
    @DisplayName("Obtengo la lista de seguidores de un usuario ordenado alfabeticamente:Ok")
    void getFollowersListOrdenDescOk() throws Exception {
        //Arrange
        SellerFListDTO sellerResp = datos.getFirstSellerFListDTO("desc");

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list?order={order}",5000,"name_desc").contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        SellerFListDTO sellerFListDTO = objectMapper.readValue(response.getResponse().getContentAsString(), SellerFListDTO.class);
        List<PersonDTO> followers = sellerFListDTO.getFollowers();
        assertAll(
                ()->assertEquals(3,followers.size()),
                ()->assertEquals(followers.get(0).getUserName(),sellerResp.getFollowers().get(0).getUserName()),
                ()->assertEquals(followers.get(1).getUserName(),sellerResp.getFollowers().get(1).getUserName()),
                ()->assertEquals(followers.get(2).getUserName(),sellerResp.getFollowers().get(2).getUserName())

        );
    }

    //Test Get followersList:Person not found

    @Test
    @DisplayName("Obtengo la lista de seguidores de un vendedor con un orden inexistente: OrderInvalidException")
    void getFollowersListOrdenInexistente() throws Exception {
        //Arrange
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list?order={order}",5000,"no_existe").contentType(MediaType.APPLICATION_JSON);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        (result -> Assertions.assertTrue(result.getResolvedException() instanceof OrderInvalidException)),
                        (result -> Assertions.assertEquals("El orden solicitado no existe", result.getResolvedException().getMessage()))
                );
    }



//TODO
    //Test getFollowedList: Obtengo la lista de seguidos de un usuario
    @Test
    @DisplayName("Obtengo la lista de seguidos de un usuario:Ok")
    void getFollowedListOk() throws Exception {
        //Arrange
        UserListDTO userResp = datos.getFirstUserListDTO("");

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",5000).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        UserListDTO userList = objectMapper.readValue(response.getResponse().getContentAsString(), UserListDTO.class);
        assertAll(
                ()->assertEquals(5000, userList.getUserId()),
                ()->assertEquals(3,userList.getFollowed().size())

        );
    }


    //Test GetFollowersList: Vacio
    @Test
    @DisplayName("Obtengo la cantidad de seguidos de un usuario sin seguidos:Caso borde")
    void getFollowedListEmpty() throws Exception {
        //Arrange
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",5004).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        UserListDTO userList = objectMapper.readValue(response.getResponse().getContentAsString(), UserListDTO.class);
        assertAll(
                ()->assertEquals(5004, userList.getUserId()),
                ()->assertEquals(0,userList.getFollowed().size())

        );
    }


    //Test Get followersList:Person not found

    @Test
    @DisplayName("Obtengo la lista de seguidos de un usuario inexistente: PersonNotFoundException")
    void getFollowedListInexistente() throws Exception {
        //Arrange
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",5999).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        (result -> Assertions.assertTrue(result.getResolvedException() instanceof PersonNotFoundException)),
                        (result -> Assertions.assertEquals("El usuario con el id: 5999 no existe", result.getResolvedException().getMessage()))
                );
    }

    //Test getFollowersList: Obtengo la lista de followers de un usuario
    @Test
    @DisplayName("Obtengo la lista de seguidos de un usuario ordenado alfabeticamente:Ok")
    void getFollowedListOrdenAscOk() throws Exception {
        //Arrange
        UserListDTO userResp = datos.getFirstUserListDTO("asc");

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list?order={order}",5000,"name_asc").contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        UserListDTO userList = objectMapper.readValue(response.getResponse().getContentAsString(), UserListDTO.class);
        List<PersonDTO> followed = userList.getFollowed();
        assertAll(
                ()->assertEquals(3,followed.size()),
                ()->assertEquals(followed.get(0).getUserName(),userResp.getFollowed().get(0).getUserName()),
                ()->assertEquals(followed.get(1).getUserName(),userResp.getFollowed().get(1).getUserName()),
                ()->assertEquals(followed.get(2).getUserName(),userResp.getFollowed().get(2).getUserName())

        );

    }

    //Test getFollowersList: Obtengo la lista de followers de un usuario
    @Test
    @DisplayName("Obtengo la lista de seguidos de un usuario ordenado alfabeticamente:Ok")
    void getFollowedListOrdenDescOk() throws Exception {
        //Arrange
        UserListDTO userResp = datos.getFirstUserListDTO("desc");

        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list?order={order}",5000,"name_desc").contentType(MediaType.APPLICATION_JSON);
        //act &assert
        MvcResult response = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                )
                .andReturn();


        ObjectMapper objectMapper = new ObjectMapper();
        UserListDTO userList = objectMapper.readValue(response.getResponse().getContentAsString(), UserListDTO.class);
        List<PersonDTO> followed = userList.getFollowed();
        assertAll(
                ()->assertEquals(3,followed.size()),
                ()->assertEquals(followed.get(0).getUserName(),userResp.getFollowed().get(0).getUserName()),
                ()->assertEquals(followed.get(1).getUserName(),userResp.getFollowed().get(1).getUserName()),
                ()->assertEquals(followed.get(2).getUserName(),userResp.getFollowed().get(2).getUserName())

        );
    }

    //Test Get followersList:Person not found

    @Test
    @DisplayName("Obtengo la lista de seguidos de un usuario con un orden inexistente: OrderInvalidException")
    void getFollowedListOrdenInexistente() throws Exception {
        //Arrange
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list?order={order}",5000,"no_existe").contentType(MediaType.APPLICATION_JSON);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        (result -> Assertions.assertTrue(result.getResolvedException() instanceof OrderInvalidException)),
                        (result -> Assertions.assertEquals("El orden solicitado no existe", result.getResolvedException().getMessage()))
                );
    }

    //Se realiza una prueba de las validaciones de entrada para probar que se este capturando correctamente
    @Test
    @DisplayName("Obtengo la lista de seguidos de un usuario con error de validacion: ErrorValidation")
    void getFollowedListValidaciones() throws Exception {
        //Arrange
        //Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followed/list",0).contentType(MediaType.APPLICATION_JSON);
        //act &assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        (result -> Assertions.assertTrue(result.getResolvedException() instanceof ConstraintViolationException)),
                        (result -> Assertions.assertEquals("getFollowedList.userId: El id debe ser mayor a cero.", result.getResolvedException().getMessage()))
                );
    }
    //POST METHODS






}

