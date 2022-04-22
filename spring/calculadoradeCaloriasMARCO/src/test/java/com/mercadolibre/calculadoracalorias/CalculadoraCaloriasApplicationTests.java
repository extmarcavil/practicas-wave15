package com.mercadolibre.calculadoracalorias;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraCaloriasApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  //a) Retornar las calorias totales del plato
  @Test
  void getDishTotalCalories() throws Exception {
    String request = "{\"name\": \"Ensalada\", \"ingredients\": [" +
        createIngredient("Calabaza", 100) + "," +
        createIngredient("Cebolla", 50) +
        "]}";
    this.mockMvc.perform(
        post("/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("47")));
  }

  //b) Retornar la calorias de cada ingrediente
  @Test
  void getDishIngredientsCalories() throws Exception {
    String request = "{\"name\": \"Ensalada\", \"ingredients\": [" +
        createIngredient("Calabaza", 100) + "," +
        createIngredient("Cebolla", 50) +
        "]}";
    this.mockMvc.perform(
        post("/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.ingredients[0].calories").value(24))
        .andExpect(jsonPath("$.ingredients[1].calories").value(23));
  }

  //c) Cual es el ingrediente con mas calorias
  @Test
  void caloricIngredient() throws Exception {
    String request = "{\"name\": \"Ensalada\", \"ingredients\": [" +
        createIngredient("Calabaza", 100) + "," +
        createIngredient("Cebolla", 70) +
        "]}";
    this.mockMvc.perform(
        post("/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.caloric.name").value("Cebolla"));
  }

  //d) Optional: Generar endpoint para recibir un listo de platos y devolver el listado procesado.
  @Test
  void processListOfPlates() throws Exception {
    String request = "[" +
        "{\"name\": \"Ensalada\", \"ingredients\": [" +
        createIngredient("Calabaza", 100) + "," +
        createIngredient("Cebolla", 70) + "]}," +
        "{\"name\": \"Hamburguesa\", \"ingredients\": [" +
        createIngredient("Hamburguesa", 100) + "," +
        createIngredient("Pan de trigo blanco", 100) + "," +
        createIngredient("Cebolla", 70) + "]}" +
        "]";
    this.mockMvc.perform(
        post("/calculateAll")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].calories").value("56"))
        .andExpect(jsonPath("$[1].calories").value("517"));
  }

  private String createIngredient(String name, int weight) {
    return "{\"name\": \""+name+"\", \"weight\": "+weight+"}";
  }

}
