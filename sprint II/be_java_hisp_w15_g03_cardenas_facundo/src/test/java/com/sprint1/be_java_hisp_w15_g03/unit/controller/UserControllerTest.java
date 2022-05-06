package com.sprint1.be_java_hisp_w15_g03.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MeliRepository meliRepository;

    @Autowired
    MockMvc mockMvc;

    User user1;
    User user2;
    User user3;
    User user4;

    Seller seller1;
    Seller seller2;
    Seller seller3;
    Seller seller4;

    @BeforeEach
    void setup() {
        meliRepository = new MeliRepository();

        user1 = new User(20, "Facundo");
        user2 = new User(22, "Pablo");

        seller1 = new Seller(24, "Netflix");
        seller2 = new Seller(25, "Spotify");

        user3 = meliRepository.addUser(user1);
        user4 = meliRepository.addUser(user2);
        seller3 = meliRepository.addSeller(seller1);
        seller4 = meliRepository.addSeller(seller2);
    }


    @Test
    @DisplayName("Verifico que un usuario siga a un vendedor")
    void followersSeller() throws Exception {

        ResultMatcher expectedStatus = status().isOk();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollow}",
                user3.getUserId(), seller3.getUserId());

        //act && assert
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Verifico la cantidad de seguidores de un vendedor")
    void followersCount() throws Exception {

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/count",
                seller4.getUserId());
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        SellerCountDTO sellerCountDTO = objectMapper.readValue(result.getResponse()
                .getContentAsString(), SellerCountDTO.class);


        Assertions.assertEquals(sellerCountDTO.getFollowersCount(), 0);

    }

    @Test
    @DisplayName("Verifico que un usuario deja de seguir a un vendedor")
    void unFollowSeller() throws Exception {

        user3.getFollowed().add(seller3);
        seller3.getFollowers().add(user3);

        ResultMatcher expectedStatus = status().isOk();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/unfollow/{userIdToUnfollow}",
                user3.getUserId(), seller3.getUserId());

        //act && assert
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Se intenta dejar de seguir a un vendedor con un usuario inexistente: PersonNotFoundException")
    void unFollowSellerPersonNotFoundException() throws Exception {

        ResultMatcher expectedStatus = status().is4xxClientError();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/unfollow/{userIdToUnfollow}",
                user4.getUserId(), seller4.getUserId());

        //act && assert
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("Se intenta seguir a un vendedor inexistente: PersonNotFoundException")
    void followSellerException() throws Exception {

        //arrange
        ResultMatcher expectedStatus = status().is4xxClientError();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollow}",
                33, 221);

        //act && assert
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(MockMvcResultHandlers.print());

    }



    @Test
    @DisplayName("Verifico que la lista de seguidores de un vendedor sea la correcta")
    void followerListOfSeller() throws Exception {

        //arrange
        user3.getFollowed().add(seller3);
        seller3.getFollowers().add(user3);
        seller3.getFollowers().add(user4);


        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list",
                seller3.getUserId());

        //act & assert
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        SellerFListDTO sellerFListDTO = objectMapper.readValue(result.getResponse()
                .getContentAsString(), SellerFListDTO.class);


        Assertions.assertEquals(sellerFListDTO.getFollowers().get(0).getUserId(), user3.getUserId());
        Assertions.assertEquals(sellerFListDTO.getFollowers().get(1).getUserId(), user4.getUserId());

    }

    @Test
    @DisplayName("Verifico que la lista de seguidos de un usuario sea la correcta")
    void followedListOfUser() throws Exception {

        //arrange
        user3.getFollowed().add(seller3);
        user3.getFollowed().add(seller4);


        //act & assert
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list",
                user3.getUserId());
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        UserListDTO userListDTO = objectMapper.readValue(result.getResponse()
                .getContentAsString(), UserListDTO.class);

        Assertions.assertEquals(userListDTO.getFollowed().get(0).getUserId(), seller3.getUserId());
        Assertions.assertEquals(userListDTO.getFollowed().get(1).getUserId(), seller4.getUserId());
    }

    @Test
    @DisplayName("Verifico que la lista de seguidos de un usuario inexistente")
    void followedListOfUserException() throws Exception {


        ResultMatcher expectedStatus = status().is4xxClientError();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list",
                66);
        MvcResult result = mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andReturn();
    }

}
