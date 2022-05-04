package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudentTest() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .writer();

        ArrayList<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(new SubjectDTO("Matemática", 9.0));
        listSubject.add(new SubjectDTO("Física", 7.0));
        listSubject.add(new SubjectDTO("Química", 6.0));
        StudentDTO studentDTO = new StudentDTO(3L, "Jose", null, null, listSubject);

        String studentJSON = writer.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
