package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.integration;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.FollowRequestDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository repository;
    User u2;
    User u1;

    @BeforeEach
    public void setup(){
        u2 = UserFactory.createJesu();
        u1 = UserFactory.createThiago();
        Product detail = ProductFactory.create();
        repository.create(u2, LocalDate.of(2022,05,05), detail, 1,120F);
    }




    // -------------------- PARTE INDIVIDUAL --------------------//


    @Test
    @DisplayName("Verifico que un usuario siga a otro que sea vendedor")
    void followSeller() throws Exception {

        ResultMatcher expectedStatus = status().isOk();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollow}",
                u1.getUserId(), u2.getUserId());

        //act && assert
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    @DisplayName("Verifico que un usuario no pueda seguir a uno que no es vendedor")
    void followNotSeller() throws Exception {

        ResultMatcher expectedStatus = status().isBadRequest();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollow}",
                u2.getUserId(), u1.getUserId());

        //act && assert
        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(MockMvcResultHandlers.print());
    }


}
