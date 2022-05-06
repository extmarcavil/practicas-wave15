package com.sprint1.be_java_hisp_w15_g4.integration;


import Utils.TestGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g4.dto.UserDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowingListDTO;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint1.be_java_hisp_w15_g4.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    IUserRepository repo = new UserRepository();

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Se prueba el countFollowers del User Controller")
    void testCountFollowersIntegration() throws Exception {

        //Arrange

        User userOne = TestGenerator.userWithFollowers();

        MockHttpServletRequestBuilder requestFollow = MockMvcRequestBuilders.post("/users/{user_Id}/follow/{user_IdToFollow}", 2, userOne.getUser_id());
        MockHttpServletRequestBuilder requestFollowTwo = MockMvcRequestBuilders.post("/users/{user_Id}/follow/{user_IdToFollow}", 3, userOne.getUser_id());
        MockHttpServletRequestBuilder requestFollowThree = MockMvcRequestBuilders.post("/users/{user_Id}/follow/{user_IdToFollow}", 4, userOne.getUser_id());
        mockMvc
                .perform(requestFollow);
        mockMvc
                .perform(requestFollowTwo);
        mockMvc
                .perform(requestFollowThree);

        ObjectWriter writer =  new ObjectMapper()
            .registerModule(new JavaTimeModule()) // convertir fechas
            .writer();

        FollowerCountDTO countDTO = new FollowerCountDTO(userOne.getUser_id(), userOne.getUser_name(), userOne.getFollowers().size());
        String usersCountJson = writer.writeValueAsString(countDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(usersCountJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestGetFollowersCount = MockMvcRequestBuilders.get("/users/1/followers/count");

        //act & assert
        mockMvc
                .perform(requestGetFollowersCount)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }


    @Test
    @DisplayName("Se prueba seguir a un vendedor")
    void testFollowIntegration() throws Exception{
        //expect
        MockHttpServletRequestBuilder requestFollowOneToTwo = MockMvcRequestBuilders.post("/users/{user_Id}/follow/{user_IdToFollow}", 2, 3);

        //act&assert
        mockMvc
                .perform(requestFollowOneToTwo)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Se prueba dejar de seguir a un vendedor")
    void testUnfollowIntegration() throws Exception{
        User userOne = TestGenerator.GenerateUser(1, "nombre1");
        User userTwo = TestGenerator.GenerateUser(2, "nombre2");
        //expect
        MockHttpServletRequestBuilder requestFollowOneToTwo = MockMvcRequestBuilders.post("/users/{user_Id}/follow/{user_IdToFollow}", userOne.getUser_id(), userTwo.getUser_id());
        MockHttpServletRequestBuilder requestUnfollowOneToTwo = MockMvcRequestBuilders.post("/users/{user_Id}/unfollow/{user_IdToFollow}", userOne.getUser_id(), userTwo.getUser_id());
        //act&assert
        mockMvc
                .perform(requestFollowOneToTwo)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc
                .perform(requestUnfollowOneToTwo)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Se prueba obtener la lista de los seguidores")
    void testFollowersListIntegration() throws Exception{
        ModelMapper mapper = new ModelMapper();
        //expect
        MockHttpServletRequestBuilder requestFollow = MockMvcRequestBuilders.post(
                "/users/{user_Id}/follow/{user_IdToFollow}", 1, 2);
        //act&assert
        mockMvc
                .perform(requestFollow);

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        List<UserDTO> listUserDTO = new ArrayList<>();
        UserDTO resultado = new UserDTO(1, "nombre1");
        listUserDTO.add(resultado);
        FollowerListDTO listDTO = new FollowerListDTO(2, "nombre2", listUserDTO);
        String usersListJson = writer.writeValueAsString(listDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        //ResultMatcher expectedJson = MockMvcResultMatchers.jsonPath("$.followers").value(usersListJson);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(usersListJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestGetFollowersList = MockMvcRequestBuilders.get("/users/2/followers/list");

        //act & assert
        mockMvc
                .perform(requestGetFollowersList)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );

    }

    @Test
    @DisplayName("Se prueba obtener la lista de los seguidos")
    void testFollowingListIntegration() throws Exception{
        ModelMapper mapper = new ModelMapper();

        //expect
        MockHttpServletRequestBuilder requestFollowOneToTwo = MockMvcRequestBuilders.post(
                "/users/{user_Id}/follow/{user_IdToFollow}", 1, 2);
        //act&assert
        mockMvc
                .perform(requestFollowOneToTwo);

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        List<UserDTO> listUserDTO = new ArrayList<>();
        UserDTO resultado = new UserDTO(2, "nombre2");
        listUserDTO.add(resultado);
        FollowingListDTO listDTO = new FollowingListDTO();
        listDTO.setUser_id(1);
        listDTO.setUser_name("nombre1");
        listDTO.setFollowed(listUserDTO);
        String usersListJson = writer.writeValueAsString(listDTO);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(usersListJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder requestGetFollowersList = MockMvcRequestBuilders.get("/users/1/followed/list");

        //act & assert
        mockMvc
                .perform(requestGetFollowersList)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );
    }

}
