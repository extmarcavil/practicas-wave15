package com.example.demo.controller;

import com.example.demo.dto.PersonaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testHelloPersonDto() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/helloPerson"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value("la persona fue guardada"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    void testHelloPersonDtoWithPathVariable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/helloPerson/{name}","Martin"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje")
                        .value("Hola Martin!"))
                .andReturn();
    }


    @Test
    void testHelloPersonDtoWithRequestParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/helloPerson")
                        .param("name","Martin"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje")
                        .value("Hola Martin!"));

    }

    @Test
    void testCreatePerson() throws Exception{
        PersonaDTO payloadDTO = new PersonaDTO("Martin","Marquez","");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/createPerson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje")
                        .value("Persona creada correctamente!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.per.name").value("Martin"));

    }
}
