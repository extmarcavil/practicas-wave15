package com.sprint1.be_java_hisp_w15_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.ErrorDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.model.User;
import com.sprint1.be_java_hisp_w15_g03.repository.MeliRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import utils.UtilsTest;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class sprint2IntegrationTest {

    @Autowired
    MockMvc mockMVC;

    @Autowired
    MeliRepository repository;

    UtilsTest utils;

    @BeforeEach
    void setup() {
        utils = new UtilsTest();
        utils.createUsers();
        utils.createSellers();
        utils.createRelations();
        repository.loadTestData(utils.getUsers(), utils.getSellers(), utils.getProducts());
    }

    //---------------- US 01 ----------------

    @Test
    @DisplayName("Verifico que un usuario pueda seguir a un vendedor existente")
    public void followSellerOk() throws Exception {

        mockMVC.perform(post("/users/{userId}/follow/{userIdToFollow}", 5, 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verifico que un usuario existente no pueda seguir a un vendedor inexistente")
    public void followSellerSellerNotFound() throws Exception {

        ErrorDTO error = new ErrorDTO("Entidad no encontrada", "El vendedor o el usuario no existen");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(post("/users/{userId}/follow/{userIdToFollow}", 4, 50))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }

    @Test
    @DisplayName("Verifico que un usuario inexistente no pueda seguir a un vendedor existente")
    public void followSellerUserNotFound() throws Exception {

        ErrorDTO error = new ErrorDTO("Entidad no encontrada", "El vendedor o el usuario no existen");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(post("/users/{userId}/follow/{userIdToFollow}", 50, 4))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }

    @Test
    @DisplayName("Verifico que un usuario no pueda seguir a un vendedor si ya se estan siguiendo")
    public void followSellerRelationAlreadyExist() throws Exception {

        ErrorDTO error = new ErrorDTO("Fallo en relacion esperada", "El usuario: 3 " +
                "ya sigue al vendedor: 3");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        int sellerId = utils.getSellers().get(0).getUserId();
        int userId = utils.getSellers().get(0).getUserId();

        mockMVC.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, sellerId))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }

    @Test
    @DisplayName("Verifico que no se pueda utilizar un id 0")
    public void followSellerIdZero() throws Exception {

        mockMVC.perform(post("/users/{userId}/follow/{userIdToFollow}", 0,
                utils.getSellers().get(0).getUserId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(status().isBadRequest());
    }

    //---------------- US 02 ----------------
    @Test
    @DisplayName("Verifico la cantidad de seguidores de un vendedor existente.")
    void getFollowersCountOk() throws Exception {

        Seller seller = utils.getSellers().get(0);
        SellerCountDTO sellerCountDTO = new SellerCountDTO();
        sellerCountDTO.setFollowersCount(seller.getFollowers().size());
        sellerCountDTO.setUserId(seller.getUserId());
        sellerCountDTO.setUserName(seller.getUserName());
        ObjectWriter writer = new ObjectMapper()
                .writer();
        String sellerCountDTOJson = writer.writeValueAsString(sellerCountDTO);

        ResultMatcher expectedBody = MockMvcResultMatchers.content().json(sellerCountDTOJson);
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(get("/users/{userId}/followers/count", seller.getUserId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }

    @Test
    @DisplayName("Verifico la cantidad de seguidores de un vendendor inexistente")
    void getFollowersCountSellerNotFound() throws Exception {
        ErrorDTO error = new ErrorDTO("Entidad no encontrada", "El vendedor con el id: 50 no existe");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(get("/users/{userId}/followers/count", 50))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }

    @Test
    @DisplayName("Verifico que no se pueda utilizar un vendedor con id 0")
    void getFollowersCountSellerZero() throws Exception {
        ResultMatcher expectedStatus = status().isBadRequest();

        mockMVC.perform(get("/users/{userId}/followers/count", 0))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus);
    }

    //---------------- US 03 ----------------
    @Test
    @DisplayName("Verifico que se obtenga un listado de todos los usuarios que siguen" +
            " a un determinado vendedor valido.")
    void getFollowersListOk() throws Exception {
        Seller seller = utils.getSellers().get(0);
        ModelMapper maper = new ModelMapper();

        SellerFListDTO sellerList = new SellerFListDTO();
        sellerList.setUserId(seller.getUserId());
        sellerList.setUserName(seller.getUserName());
        sellerList.setFollowers(seller
                .getFollowers()
                .stream()
                .map((m) -> maper.map(m, PersonDTO.class))
                .collect(Collectors.toList()));

        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(sellerList));
        ResultMatcher expectedStatus = status().isOk();

        mockMVC.perform(get("/users/{userId}/followers/list", seller.getUserId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody);
    }

    @Test
    @DisplayName("Verifico que no se pueda obtener el listado de un vendedor con userId invalido")
    void getFollowersSellerNotFound() throws Exception {

        ErrorDTO error = new ErrorDTO("Entidad no encontrada", "El vendedor con el id: 15 no existe");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(get("/users/{userId}/followers/list", 15))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }

    //---------------- US 04 ----------------

    @Test
    @DisplayName("Verifico que se obtenga la lista de vendedores a los que sigue un usuario")
    void getFollowedListOk() throws Exception {

        ModelMapper mapper = new ModelMapper();
        User user = utils.getUsers().get(0);

        UserListDTO userList = new UserListDTO();
        userList.setUserId(user.getUserId());
        userList.setUserName(user.getUserName());
        userList.setFollowed(user.getFollowed()
                .stream()
                .map((m) -> mapper.map(m, PersonDTO.class))
                .collect(Collectors.toList()));

        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(userList));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);


        mockMVC.perform(get("/users/{userId}/followed/list", user.getUserId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);

    }

    @Test
    @DisplayName("Verifico que la cantidad sea 0 si un usuario no sigue a ningun vendedor")
    public void getFollowedListNoSellers() throws Exception {
        ModelMapper mapper = new ModelMapper();
        User user = utils.getUsers().get(2);

        UserListDTO userList = new UserListDTO();
        userList.setUserId(user.getUserId());
        userList.setUserName(user.getUserName());
        userList.setFollowed(user.getFollowed()
                .stream()
                .map((m) -> mapper.map(m, PersonDTO.class))
                .collect(Collectors.toList()));

        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(userList));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(get("/users/{userId}/followed/list", user.getUserId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }

    @Test
    @DisplayName("Verifico un usuario invalido en getFollowedList")
    public void getFollowedListUserNotFound() throws Exception {
        ErrorDTO error = new ErrorDTO("Entidad no encontrada", "El usuario con el id: 20 no existe");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(get("/users/{userId}/followed/list", 20))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedStatus, expectedBody, expectedContentType);
    }

    //---------------- US 05 ----------------

    @Test
    @DisplayName("Verifico que un usuario pueda dejar de seguir a un vendedor")
    public void unfollowSeller() throws Exception {
        mockMVC.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(status().isOk());
    }

    @Test
    @DisplayName("Verifico el fallo en caso de que un usuario no siga a un vendedor y quiera dejar de seguirlo")
    public void unfollowSellerNotRelation() throws Exception {
        ErrorDTO error = new ErrorDTO("Fallo en relacion esperada", "El usuario: 5 no sigue al vendedor: 3");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 5, 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(status().isNotFound(), expectedBody, expectedContentType);
    }

    @Test
    @DisplayName("Verifico el fallo en caso de que un usuario no exista")
    public void unfollowSellerUserNotFound() throws Exception {
        ErrorDTO error = new ErrorDTO("Entidad no encontrada",
                "El vendedor o el usuario no existen");
        ObjectWriter writer = new ObjectMapper()
                .writer();
        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        mockMVC.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 30, 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(status().isNotFound(), expectedBody, expectedContentType);
    }

    //---------------- US 06 ----------------

    @Test
    @DisplayName("Verifico el guardado de una publicacion correcta")
    public void savePublicationOk() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        ProductDTO product = new ProductDTO(1,"mesa","no se","algo",
                "Blanco","lala");
        PublicationDTO post = new PublicationDTO(3, LocalDate.now(),product,0,50.0);

        String payload = writer.writeValueAsString(post);

        mockMVC.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(status().isOk());
    }

    @Test
    @DisplayName("Verifico el fallo en caso de un seller id invalido")
    public void savePublicationSellerNotFound() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        ProductDTO product = new ProductDTO(1,"mesa","no se","algo",
                "Blanco","lala");
        PublicationDTO post = new PublicationDTO(30, LocalDate.now(),product,0,50.0);

        String payload = writer.writeValueAsString(post);

        ErrorDTO error = new ErrorDTO("Entidad no encontrada",
                "El vendedor con el id: 30 no existe");

        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);


        mockMVC.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedBody,expectedContentType,status().isNotFound());
    }

    @Test
    @DisplayName("Verifico el fallo en caso de una categoria invalida")
    public void savePublicationCategoryInvalid() throws Exception {

        ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();

        ProductDTO product = new ProductDTO(1,"mesa","no se","algo",
                "Blanco","lala");
        PublicationDTO post = new PublicationDTO(30, LocalDate.now(),product,100,50.0);

        String payload = writer.writeValueAsString(post);

        ErrorDTO error = new ErrorDTO("Fallo en categoria esperada",
                "La categoria 100 no existe.");

        ResultMatcher expectedBody = content().json(writer.writeValueAsString(error));
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);


        mockMVC.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(expectedBody,expectedContentType,status().isNotFound());
    }

}
