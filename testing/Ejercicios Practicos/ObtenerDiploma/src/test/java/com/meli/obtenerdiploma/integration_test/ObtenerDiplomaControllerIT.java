package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.StudentFactory;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.DecimalFormat;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void analyzeScores() throws Exception {
        ObjectWriter writer= new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        Long id=1L;

        //promedio 7 y msj puedes mejorar
        StudentDTO expect= StudentFactory.getJuan();
        expect.setAverageScore(7.);
        expect.setMessage("El alumno " + expect.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#.##").format(expect.getAverageScore())
                +". Puedes mejorar.");

        String jsonExpected=writer.writeValueAsString(expect);

        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isOk();//200
        ResultMatcher body= MockMvcResultMatchers.content().json(jsonExpected);
        ResultMatcher contentType= MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1);

        //act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        status,
                        body,
                        contentType,
                        MockMvcResultMatchers.jsonPath("$.subjects[1].score").value("6.0")
                );
    }

    @Test
    void analyzeScoresNotOk() throws Exception {

        String jsonExpected="{\"name\":\"StudentNotFoundException\",\"description\":\"El alumno con Id 9 no se encuetra registrado.\"}";

        //Expected
        ResultMatcher status= MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentType= MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher body=MockMvcResultMatchers.content().json(jsonExpected);

        //Request
        MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/analyzeScores/{studentId}",9);

        //act & assert
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        status,
                        contentType,
                        body
                );
    }
}
