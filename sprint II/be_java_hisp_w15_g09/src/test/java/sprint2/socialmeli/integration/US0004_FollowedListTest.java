package sprint2.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sprint2.socialmeli.dto.user.ResponseFollowedListDTO;
import sprint2.socialmeli.dto.user.ResponseFollowersListDTO;
import sprint2.socialmeli.dto.user.UserDTO;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class US0004_FollowedListTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectWriter writer;

    @BeforeEach
    void setUp(){
        this.writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test01GetListOfFollowedCorrectly() throws Exception {

        UserDTO alan = new UserDTO(3,"Alan Gimenez");
        UserDTO lorena = new UserDTO(1,"Lorena Maciel");
        ResponseFollowedListDTO aExpectedList = new ResponseFollowedListDTO(2,"Gonzalo Murias", Arrays.asList(alan,lorena));

        String espectedListAsJson = this.writer.writeValueAsString(aExpectedList);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",2,1));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",2,3));


        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",2))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedListAsJson, mvcResult.getResponse().getContentAsString());
    }


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test02GetListOfFollowedOrderedByNameAsc() throws Exception {

        UserDTO alan = new UserDTO(3,"Alan Gimenez");
        UserDTO lorena = new UserDTO(1,"Lorena Maciel");
        UserDTO ramiro = new UserDTO(4,"Ramiro Vera");

        ResponseFollowedListDTO aExpectedList = new ResponseFollowedListDTO(2,"Gonzalo Murias", Arrays.asList(alan,lorena,ramiro));

        String espectedListAsJson = this.writer.writeValueAsString(aExpectedList);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",2,1));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",2,3));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",2,4));

        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_asc",2))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedListAsJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test02GetListOfFollowedOrderedByNameDesc() throws Exception {

        UserDTO alan = new UserDTO(3,"Alan Gimenez");
        UserDTO lorena = new UserDTO(1,"Lorena Maciel");
        UserDTO ramiro = new UserDTO(4,"Ramiro Vera");

        ResponseFollowedListDTO aExpectedList = new ResponseFollowedListDTO(2,"Gonzalo Murias", Arrays.asList(ramiro,lorena,alan));

        String espectedListAsJson = this.writer.writeValueAsString(aExpectedList);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",2,1));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",2,3));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",2,4));

        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_desc",2))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedListAsJson, mvcResult.getResponse().getContentAsString());
    }
}
