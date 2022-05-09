package com.example.be_java_hisp_w15_g05.IntegracionTest;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListSellersDTO;
import com.example.be_java_hisp_w15_g05.dto.UserDTO;
import com.example.be_java_hisp_w15_g05.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowsControllerTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    public void testCountFollowers() throws Exception {
        ObjectWriter writer =new ObjectMapper().writer();

        //arrange
        ResCountFollowersDTO dto= new ResCountFollowersDTO(1,"Marcos Galperin",2);
        String respJson= writer.writeValueAsString(dto);

        //expected
        ResultMatcher expectedStatus= MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType= MockMvcResultMatchers.content().json(respJson);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(respJson);


        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count",1);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus,
                        expectedContentType,
                        expectedStatus
                        );
    }

    @Test
    public void testGetListFollowers() throws Exception {
        ObjectWriter writer =new ObjectMapper().writer();

        //arrange
        UserDTO user1= new UserDTO(10,"Juan");
        UserDTO user2= new UserDTO(11,"APedro");

        ResListFollowersDTO dto= new ResListFollowersDTO(1,"Marcos Galperin",List.of(user2,user1));
        String respJson= writer.writeValueAsString(dto);

        //expected
        ResultMatcher expectedStatus= MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType= MockMvcResultMatchers.content().json(respJson);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(respJson);


        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list/",1);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus,
                        expectedContentType,
                        expectedJson);
    }

    @Test
    public void TestGetListFollowed() throws Exception{
        ObjectWriter writer =new ObjectMapper().writer();

        //arrange
       UserDTO user2= new UserDTO(11,"APedro");
       UserDTO seller= new UserDTO(1,"Marcos Galperin");

        ResListSellersDTO dto= new ResListSellersDTO(11,"APedro",List.of(seller));
        String respJson= writer.writeValueAsString(dto);

        //expected
        ResultMatcher expectedStatus= MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType= MockMvcResultMatchers.content().json(respJson);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(respJson);


        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list",11);

        //act & assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus,
                        expectedContentType,
                        expectedJson);
        
    }


}
