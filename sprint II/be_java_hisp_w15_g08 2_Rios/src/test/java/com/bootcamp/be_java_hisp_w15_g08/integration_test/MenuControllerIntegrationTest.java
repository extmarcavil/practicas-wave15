package com.bootcamp.be_java_hisp_w15_g08.integration_test;

import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class MenuControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private Map<Integer, User> users;

    @BeforeEach
    public void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        users = new HashMap<>();

        User user1 = new User(1234,"Cosme Fulanito");
        User user2 = new User(1235,"Max Power");
        User user3 = new User(1236,"Homer Thompson");
        User user4 = new User(1237,"Mister Json");

        users.put(user1.getUserID(),user1);
        users.put(user2.getUserID(),user2);
        users.put(user3.getUserID(),user3);
        users.put(user4.getUserID(),user4);

    }

    @Test
    @DisplayName("Verificamos que el se siguiera al usuario correcto")
    public void VerifyFollowuser() throws Exception{
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1234, 1235))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);
    }

}
