package com.meli.obtenerdiploma.unit.integration_test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.xml.transform.Result;
import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testAnalyzeScoresWithPathVariable() throws Exception{
        /*ObjectWriter writer =  new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();*/
        //Arrange
        /*ArrayList<SubjectDTO> listaMaterias = new ArrayList<>();
        listaMaterias.add(new SubjectDTO("Matemática", 9.0));
        listaMaterias.add(new SubjectDTO("Física", 7.0));
        listaMaterias.add(new SubjectDTO("Química", 6.0));
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, listaMaterias);
        String jsonResult = writer.writeValueAsString(studentDTO);*/

        // -- VERSION MARCO ---

        /*//Expected
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(jsonResult);
        //Request

        //Normal
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}",1);
        //Act & Assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );*/
        // -- VERSION TINCHO --
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.averageScore").value(IsNull.nullValue())
                        //MockMvcResultMatchers.content().json(jsonResult)
                );
    }


}
