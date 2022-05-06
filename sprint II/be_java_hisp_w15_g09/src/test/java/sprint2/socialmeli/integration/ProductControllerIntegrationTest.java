package sprint2.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sprint2.socialmeli.dto.user.ResponseFollowersCountDTO;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.repository.SocialMeliRepository;
import sprint2.socialmeli.service.ISocialMeliService;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ISocialMeliService iSocialMeliService;

    @Test
    void followBien() throws Exception {
        String payloadDTO = "El usuario: 1 comenzo a seguir a 2";

        mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}", 1, 2)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().string(payloadDTO));
    }

    @Test
    void followMalHimself() throws Exception {

        //CAMBIAR ESTO QUE ESTÁ HORRIBLE
        String payloadDTO = "El usuario no puede seguirse a si mismo";
        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);
        mockMvc
                .perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}", 1, 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.content().string("{\"name\":\"InvalidFollower\",\"message\":\"El usuario no puede seguirse a si mismo\"}")
                        );
    }



    @Test
    void countFollowers() throws Exception {
        SocialMeliRepository userDB = new SocialMeliRepository();
        iSocialMeliService.follow(2,1);
        User lorena = userDB.findUserById(1);
        ResponseFollowersCountDTO payloadDTO =
                new ResponseFollowersCountDTO(lorena.getId(), lorena.getName(), 1);



        ObjectWriter writer = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().json(payloadJson),
                        MockMvcResultMatchers.jsonPath("$.followers_count").value(1));

    }
}
