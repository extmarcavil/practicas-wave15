package sprint2.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sprint2.socialmeli.exceptions.ErrorDTO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class US0001_FollowTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test01UserFollowsAnotherUserCorrectly() throws Exception {
        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",1,2))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals("El usuario: 1 comenzo a seguir a 2", mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test02UserCantFollowsHimself() throws Exception {

        ErrorDTO expectedError = new ErrorDTO("InvalidFollower","El usuario no puede seguirse a si mismo");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String espectedErrorAsJson = writer.writeValueAsString(expectedError);

        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",1,1))
                        .andDo(print())
                        .andExpect(status().isBadRequest())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedErrorAsJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test03UserCantFollowsAnAlreadyFollowedUser() throws Exception {

        ErrorDTO expectedError = new ErrorDTO("InvalidFollower","El usuario no puede seguir a alguien que ya sigue");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String espectedErrorAsJson = writer.writeValueAsString(expectedError);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",1,2));

        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",1,2))
                        .andDo(print())
                        .andExpect(status().isBadRequest())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedErrorAsJson, mvcResult.getResponse().getContentAsString());
    }


}
