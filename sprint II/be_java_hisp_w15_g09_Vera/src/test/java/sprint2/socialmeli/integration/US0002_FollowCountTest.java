package sprint2.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
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
import sprint2.socialmeli.dto.user.ResponseFollowersCountDTO;
import sprint2.socialmeli.exceptions.ErrorDTO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class US0002_FollowCountTest {

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
    public void test01CountFollowersUserCorrectly() throws Exception {

        ResponseFollowersCountDTO expectedCount = new ResponseFollowersCountDTO(2,"Gonzalo Murias",2);

        String espectedCountAsJson = this.writer.writeValueAsString(expectedCount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",1,2));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",3,2));

        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",2))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedCountAsJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test02CantGetCountOfAnUnexistingUser() throws Exception {

        int testId = 25;
        ErrorDTO expectedError = new ErrorDTO("UserNotFound","Usuario con id: "+ testId + " no fue encontrado");

        String espectedErrorAsJson = this.writer.writeValueAsString(expectedError);
        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",testId))
                        .andDo(print())
                        .andExpect(status().is4xxClientError())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedErrorAsJson, mvcResult.getResponse().getContentAsString());
    }

}
