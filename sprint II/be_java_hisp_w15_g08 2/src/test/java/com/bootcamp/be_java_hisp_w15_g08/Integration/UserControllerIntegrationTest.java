package com.bootcamp.be_java_hisp_w15_g08.Integration;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import java.util.List;
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {


        @Autowired
        MockMvc mockMvc;

        @Test
        void getUserFollowerListTest() throws Exception {
            ObjectWriter writer =  new ObjectMapper()
                    .writer();

            // arrange
            UserDTO user1 = new UserDTO(1234,"Cosme Fulanito");

            UserDTO user2 = new UserDTO(1235,"Max Power");
            UserDTO user3 = new UserDTO(1236,"Homer Thompson");

            List<UserDTO> followersList = new ArrayList<>();

            followersList.add(user2);
            followersList.add(user3);


          FollowersListDTO followersListDTO= new FollowersListDTO();
          followersListDTO.setUser_id(1234);
          followersListDTO.setUser_name("Cosme Fulanito");
          followersListDTO.setFollowers(followersList);

            String Json = writer.writeValueAsString(followersListDTO);

            // EXPECTED esperados
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isAccepted();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(Json);
            ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


            // REQUEST
            //normal
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/list",followersListDTO.getUser_id());



            // act & assert
            mockMvc
                    .perform(request)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpectAll(
                            expectedStatus,
                            expectedJson,
                            expectedContentType
                    );
        }
}
