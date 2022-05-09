package sprint2.socialmeli.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sprint2.socialmeli.dto.user.ResponseFollowersCountDTO;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public class SocialMeliControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    //T-0001
    @Test
    @DisplayName("Verificar que el usuario a seguir exista")
    public void test01UserToFollowExists() throws Exception{
        Integer userID = 1;
        Integer userIdToFollow = 2;
        String expectedMessage = "El usuario: "+ userID + " comenzo a seguir a "+ userIdToFollow;
                mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",userID,userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().string(expectedMessage)
                );
    }

    @Test
    @DisplayName("Verificar que el usuario a seguir no exista")
    public void test01UserToFollowDoesNotExist() throws Exception{
        Integer userID = 1;
        Integer userIdToFollow = 200;
        String expectedMessage = "Usuario con id: "+ userIdToFollow + " no fue encontrado";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",userID,userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isNotFound(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("UserNotFound"),
                        MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage)
                );
    }

    @Test
    @DisplayName("Verificar que usuarios con id negativos no sean validos para seguir")
    public void test01UserToFollowWithIdNegative() throws Exception{
        Integer userID = -1;
        Integer userIdToFollow = -2;
        String expectedMessageUserId = "follow.userID: El id debe ser mayor a cero";
        String expectedMessageUserIdToFollow = "follow.userIdToFollow: El id debe ser mayor a cero";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",userID,userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isNotFound(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("RuntimeException"),
                        MockMvcResultMatchers.jsonPath("$.message", Matchers.containsString(expectedMessageUserId)),
                        MockMvcResultMatchers.jsonPath("$.message", Matchers.containsString(expectedMessageUserIdToFollow))
                );
    }

    @Test
    @DisplayName("Verificar que el usuario no puede seguirse a si mismo")
    public void testUserCanNotFollowThemselves() throws Exception{
        Integer userID = 1;
        Integer userIdToFollow = 1;
        String expectedMessage = "El usuario no puede seguirse a si mismo";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}",userID,userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("InvalidFollower"),
                        MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage)
                );
 }

    @Test
    @DisplayName("Verificar que el usuario no puede seguir a un usuario que ya sigue")
    public void testUserCanNotFollowTheSameUserTwice() throws Exception{
        Integer userID = 2;
        Integer userIdToFollow = 4;
        String expectedMessage = "El usuario no puede seguir a alguien que ya sigue";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToUnfollow}",userID,userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("InvalidFollower"),
                        MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage)
                );
    }

    //T-0002
    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir exista")
    public void test02UserToUnfollowExists() throws Exception{
        Integer userID = 2;
        Integer userIdToUnfollow = 6;
        String expectedMessage ="El usuario: "+ userID + " dejo de seguir a "+ userIdToUnfollow;
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}",userID,userIdToUnfollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().string(expectedMessage)
                );
          }

    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir no exista")
    public void test02UserToUnfollowDoesNotExist() throws Exception{
        Integer userID = 1;
        Integer userIdToUnfollow = 100;
        String expectedMessage = "Usuario con id: " + userIdToUnfollow + " no fue encontrado";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}",userID,userIdToUnfollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isNotFound(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("UserNotFound"),
                        MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage)
                );

    }

    @Test
    @DisplayName("Verificar que usuarios con id negativos no sean validos para dejar de seguir")
    public void test01UserToUnollowWithIdNegative() throws Exception{
        Integer userID = -1;
        Integer userIdToUnfollow = -2;
        String expectedMessageUserId = "follow.userID: El id debe ser mayor a cero";
        String expectedMessageUserIdToFollow = "unfollow.userIdToUnfollow: El id debe ser mayor a cero";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}",userID,userIdToUnfollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isNotFound(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("RuntimeException"),
                        MockMvcResultMatchers.jsonPath("$.message", Matchers.containsString(expectedMessageUserId)),
                        MockMvcResultMatchers.jsonPath("$.message", Matchers.containsString(expectedMessageUserIdToFollow))
                );
    }

    @Test
    @DisplayName("Verificar que el usuario no puede dejar de seguirse a si mismo")
    public void testUserCanNotUnfollowThemselves() throws Exception{
        Integer userID = 1;
        Integer userIdToUnfollow = 1;
        String expectedMessage = "El usuario no puede dejar de seguirse a si mismo";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}",userID,userIdToUnfollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("InvalidFollower"),
                        MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage)
                );

    }

    @Test
    @DisplayName("Verificar que el usuario no puede dejar de seguir a un usuario que no sigue")
    public void testUserCanNotUnfollowNotFollowedUser() throws Exception{
        Integer userID = 1;
        Integer userIdToUnfollow = 5;
        String expectedMessage = "El usuario no puede dejar de seguir a alguien que no sigue";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}",userID,userIdToUnfollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isBadRequest(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("InvalidFollower"),
                        MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage)
                );
         }

    // T-0007
    @Test
    @DisplayName("Verifica que la cantidad de seguidores de un usuario sea correcto")
    public  void test07verifyNumberOfFollowersByUser() throws  Exception {
        ObjectWriter writer =  new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
        Integer userID = 3;
        ResponseFollowersCountDTO expected = new ResponseFollowersCountDTO();
        expected.setUserId(userID);
        expected.setUserName("Alan Gimenez");
        expected.setFollowersCount(2);

        String expectedBody = writer.writeValueAsString(expected);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userID))
        .andDo(MockMvcResultHandlers.print())
        .andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                MockMvcResultMatchers.jsonPath("$.followers_count").value(2),
                MockMvcResultMatchers.content().json(expectedBody)
        );
    }

    @Test
    @DisplayName("Verificar que usuario con id negativos no sean validos para obtener cantidad de seguidores")
    public void test07verifyNumberOfFollowersByUserWithIdNegative() throws Exception{
        Integer userID = -1;
        String expectedMessageUserId = "countFollowers.userId: El id debe ser mayor a cero";
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userID))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isNotFound(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.name").value("RuntimeException"),
                        MockMvcResultMatchers.jsonPath("$.message", Matchers.containsString(expectedMessageUserId))
                );
    }


}
