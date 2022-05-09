package sprint2.socialmeli.unit.Integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.databind.SerializationFeature;
// import com.fasterxml.jackson.datatype.jsr310.;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestParam;
import sprint2.socialmeli.dto.ProductDTO;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;
import sprint2.socialmeli.dto.user.UserDTO;
import sprint2.socialmeli.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationOne {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @Test
    @DisplayName(" verificar que el un usuario siga a otro correctamente y no devuelva status 4xx")
    public void chequearQueUnUsuarioSigaAOtro() throws Exception {
        int usuarioSeguido = 1;
        int usuarioSeguidor = 2;

        this.mockMvc.perform(
                MockMvcRequestBuilders.post(
                        "/users/{userID}/follow/{userIdToFollow}",
                        usuarioSeguidor,
                        usuarioSeguido))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().string(
                        "El usuario: " + usuarioSeguidor + " comenzo a seguir a " + usuarioSeguido));
    }

    @Test
    @DisplayName(" verificar que al cargar un usuario no valido para obtener sus seguidores, arroje error")
    public void validarErrorAlCargarMalUsuarioAlObtenerConteoSeguidores() throws Exception {
        int usuario = 7;

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/users/{userId}/followers/count", usuario))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("UserNotFound"));
    }

    @Test
    @DisplayName(" verificar que arroje error al cargar mal el params para definir el orden de la lista")
    public void validarErrorAlCargarMalParametroAlObtenerListaSeguidores() throws Exception {
        int usuario = 1;
        String parametro = "invalido";

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/users/{userId}/followed/list", usuario).param("order", parametro))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("InvalidParamsException"));
    }

    @Test
    @DisplayName(" verificar que al obtener una lista de post, obtenga los del usuario solicitado")
    public void obtenerListaDePost () throws Exception {
        int usuario = 1;

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/products/followed/{followerUserID}/list", usuario))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(usuario));

    }

    @Test
    public void testPrueba() throws Exception {
        User payloadDTO = new User(7, "Sofia");

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }
}




