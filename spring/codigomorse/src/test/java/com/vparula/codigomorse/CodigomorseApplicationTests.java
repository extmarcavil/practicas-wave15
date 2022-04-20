package com.vparula.codigomorse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CodigomorseApplicationTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void traduzcoHola() throws Exception {
		performTest(".... --- .-.. .-", "HOLA");
	}

	@Test
	void ml() throws Exception {
		performTest("-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .", "MERCADO LIBRE");
	}

	@Test
	void ml2() throws Exception {
		performTest("-- . .-. -.-. .- -.. --- .-.. .. -... .-. .", "MERCADOLIBRE");
	}

	@Test
	void spring() throws Exception {
		performTest("... .--. .-. .. -. --.", "SPRING");
	}

	private void performTest(String morse, String alfa) throws Exception {
		this.mockMvc.perform(get("/convert/" + morse))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(alfa)));
	}
}
