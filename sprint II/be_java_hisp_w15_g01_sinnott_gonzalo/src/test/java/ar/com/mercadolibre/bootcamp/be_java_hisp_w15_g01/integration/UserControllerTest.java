package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.integration;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.ObjectWriterFactory;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.PostDTOFactory;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_integration_followUserValidUser() throws Exception {

        //Arrange
        ObjectWriter writer = ObjectWriterFactory.create();
        PostDTO p = PostDTOFactory.createPost();
        String payload = writer.writeValueAsString(p);

        MockHttpServletRequestBuilder AuxRequest = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        mockMvc.perform(AuxRequest);

        //Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",2, 1);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        //Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }

    @Test
    public void test_integration_followUserNotValidUser() throws Exception {

        //Arrange

        //Act
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",-2, 3);
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();

        //Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus
                );
    }
}
