package com.digitalhouse.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldCalculateAge() throws Exception {
    this.mockMvc.perform(get("/09/09/1989"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("31")));
  }

  @Test
  void cantCalculateAge() throws Exception {
    this.mockMvc.perform(get("/09/13/2001"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("0")));
  }

}