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
public class US0007_UnfollowTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test01UserCanUnfollowAnAlreadyFollowedUser() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",1,2));

        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}",1,2))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals("El usuario: 1 dejo de seguir a 2", mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test02UserCantUnfollowsHimself() throws Exception {

        ErrorDTO expectedError = new ErrorDTO("InvalidFollower","El usuario no puede dejar de seguirse a si mismo");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String espectedErrorAsJson = writer.writeValueAsString(expectedError);

        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnFollow}",1,1))
                        .andDo(print())
                        .andExpect(status().isBadRequest())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedErrorAsJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void test03UserCantUnfollowsAnUserThatIsNotFollowed() throws Exception {

        ErrorDTO expectedError = new ErrorDTO("InvalidFollower","El usuario no puede dejar de seguir a alguien que no sigue");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String espectedErrorAsJson = writer.writeValueAsString(expectedError);

        MvcResult mvcResult =
                this.mockMvc
                        .perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnFollow}",1,2))
                        .andDo(print())
                        .andExpect(status().isBadRequest())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(espectedErrorAsJson, mvcResult.getResponse().getContentAsString());
    }


}
