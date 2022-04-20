package com.vparula.numerosromanos;

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
class RomanNumeralsApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void oneShouldBeI() throws Exception {
		performTest("1", "I");
		performTestReves("I","1");
	}

	@Test
	void tenShouldBeX() throws Exception {
		performTest("10", "X");
		performTestReves("X", "10");

	}

	@Test
	void sevenShouldBeVII() throws Exception {
		performTest("7", "VII");
		performTestReves("VII","7");
	}

	@Test
	void fifteenShouldBeXV() throws Exception {
		performTest("15", "XV");
		performTestReves("XV","15");
	}



	private void performTest(String decimal, String roman) throws Exception {
		this.mockMvc.perform(get("/" + decimal))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(roman)));
	}

	private void performTestReves(String roman, String decimal) throws Exception {
		this.mockMvc.perform(get("/fromRoman/" + roman))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(decimal)));
	}




}
