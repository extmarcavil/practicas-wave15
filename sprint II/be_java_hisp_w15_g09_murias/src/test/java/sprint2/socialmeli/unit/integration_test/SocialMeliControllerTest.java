package sprint2.socialmeli.unit.integration_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliControllerTest {

    @Autowired
    MockMvc mockMvc;

    // T-0009 TEST INTEGRACION INDIVIDUAL OBLIGATORIO -- Verificar que el follows funcione correctamente, en caso de que no, lance excepción.
    @Test
    public void test09CheckFollowsOK() throws Exception{

        String payloadDTO = "El usuario: 1 comenzo a seguir a 2";

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}", 1, 2)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().string(payloadDTO));
    }
    @Test
    public void test09CheckFollowsNotOK() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}", 1, 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    // T-0010 BONUS -- Verificar que el unfollow funcione correctamente, en caso de que no, lance excepción.
    @Test
    public void test10CheckUnfollowsOk() throws Exception{
        String payloadDTO = "El usuario: 1 dejo de seguir a 2";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}", 1, 2)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().string(payloadDTO));
    }

    @Test
    public void test10CheckUnfollowsNotOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}", 1, 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    // T-0011 BONUS -- Verificar la cantidad de seguidores de un usuario
    @Test
    public void test11CheckFollowersCount() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",2))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().contentType("application/json"),
                        MockMvcResultMatchers.jsonPath("$.user_id").value(2),
                        MockMvcResultMatchers.jsonPath("$.followers_count").value(3));
    }


}
