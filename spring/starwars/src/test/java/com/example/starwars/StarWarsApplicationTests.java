package com.example.starwars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StarWarsApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldFoundOne() throws Exception {
    performTest("Luke", Collections.singletonList("Luke Skywalker"));
  }

  @Test
  void shouldFound() throws Exception {
    performTest("Darth", asList("Darth Vader", "Darth Maul"));
  }

  private void performTest(String query, List<String> results) throws Exception {
<<<<<<< HEAD
    ResultActions resultActions = this.mockMvc.perform(get("/" + query))
=======
    ResultActions resultActions = this.mockMvc.perform(get("/character?name=" + query))
>>>>>>> 9ae5e9bcf1fd9d821e8b0d1780ce881ce0f5689c
        .andDo(print())
        .andExpect(status().isOk());

    for (String result : results)
        resultActions.andExpect(content().string(containsString(result)));
  }
}
