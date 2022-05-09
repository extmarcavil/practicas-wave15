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
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sprint2.socialmeli.dto.ProductDTO;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;
import sprint2.socialmeli.dto.post.response.ResponsePostDTO;
import sprint2.socialmeli.dto.post.response.ResponsePostListDTO;
import sprint2.socialmeli.model.Post;
import sprint2.socialmeli.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class US0006_GetPostListTest {

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
    public void test01CanGetListOfPost() throws Exception {

        performAPostWithDate(new User(1,"Lorena Maciel"),LocalDate.now().minusDays(1));
        performAPostWithDate(new User(2,"Gonzalo Murias"),LocalDate.now().minusDays(2));
        performAPostWithDate(new User(3,"Alan Gimenez"),LocalDate.now().minusDays(3));

        this.mockMvc.perform(post("/users/{userID}/follow/{userIdToFollow}",4,1));
        this.mockMvc.perform(post("/users/{userID}/follow/{userIdToFollow}",4,2));
        this.mockMvc.perform(post("/users/{userID}/follow/{userIdToFollow}",4,3));


        this.mockMvc.
                perform(get("/products/followed/{followerUserID}/list",4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(4));
    }

    private void performAPostWithDate(User aUser , LocalDate aDate) throws Exception {
        ProductDTO aNewProduct = new ProductDTO(1,"Silla","Mueble","Marca","Negra","Producto nuevo");
        RequestPostDTO aNewPost = new RequestPostDTO(aUser.getId(), aDate,aNewProduct,1,1D);
        String newPostAsJson = this.writer.writeValueAsString(aNewPost);
        this.mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(newPostAsJson));
    }


}
