package com.bootcamp.testing.integration_test;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.model.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class MenuControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
          .registerModule(new JavaTimeModule()) // convertir fechas
          .writer();

        // arrange
        Recipe recipe = new Recipe();
        List<Recipe> recipes = new ArrayList<>();
        /*recipes.add(recipe);*/
        // body?
        // endpoint -> parametros
        // except


        String listJson = writer.writeValueAsString(recipes);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(listJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        //normal
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/menu");

        // EJEMPLOS
        // path variable
        /*MockHttpServletRequestBuilder request = get("/menu/{id}/{user_id}", 1, 2)
                                                    .param("asd", "2.2");*/
        // request param
        /*MockHttpServletRequestBuilder request = get("/menu")
                                                    .param("order", "name_asc")
                                                    .param("name", "pizza");*/

        // act & assert
        mockMvc
          .perform(request)
          .andDo(MockMvcResultHandlers.print())
          .andExpectAll(
            expectedStatus,
            expectedJson,
            expectedContentType
          );
    }

    @Test
    @DisplayName("demo test integration POST")
    void test2() throws Exception {
        ObjectWriter writer =  new ObjectMapper()
          .registerModule(new JavaTimeModule()) // convertir fechas
          .writer();

        // arrange
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("tomato");
        ingredient.setQuantity(1);
        ingredients.add(ingredient);

        Recipe recipe = new Recipe();
        recipe.setName("pizza 2");
        recipe.setDescription("akljshd");
        recipe.setIngredients(ingredients);

        /*recipes.add(recipe);*/
        // body?
        // endpoint -> parametros
        // except

        System.out.println(ingredients);
        String recipePayload = writer.writeValueAsString(recipe);
        String expectedBody = writer.writeValueAsString(recipe);

        // EXPECTED
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedBody);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/recipe")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(recipePayload);
        // act & assert
        mockMvc
          .perform(request)
          .andDo(MockMvcResultHandlers.print())
          .andExpectAll(
            expectedStatus,
            expectedJson,
            expectedContentType
          );
    }
}
