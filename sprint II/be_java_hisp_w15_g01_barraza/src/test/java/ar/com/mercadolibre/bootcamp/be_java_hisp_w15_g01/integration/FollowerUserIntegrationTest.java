package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.integration;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowerUserIntegrationTest {
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void test001() throws Exception {
		FollowersCountDTO dto = new FollowersCountDTO();
		dto.setUserId(1L);
		dto.setUserName("Lukf");
		dto.setFollowersCount(0);
		
		// request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1); // .param("order", "desc");
		
		// assert matches
		ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
		
		ObjectWriter writer = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE).writer();
		String responseJson = writer.writeValueAsString(dto);
		ResultMatcher expectedContent = MockMvcResultMatchers.content().json(responseJson);
		ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
		
		// petición al controller
		mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedContentType, expectedContent, expectedStatus);
	}
	
	@Test
	public void cuandoSePideLosSeguidoresDeUnUsuarioInexistenteTiraError404UserNotFound() throws Exception {
		// request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 7);
		
		// assert matches
		ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
		//ResultMatcher expectedErrorMessage = MockMvcResultMatchers.jsonPath("$['message']").value("The user does not exists");
		
		// petición al controller
		mockMvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpectAll(expectedStatus);
	}

}
