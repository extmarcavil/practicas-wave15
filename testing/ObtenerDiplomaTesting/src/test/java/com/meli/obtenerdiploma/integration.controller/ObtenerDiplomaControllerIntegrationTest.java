package com.meli.obtenerdiploma.integration.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    @DisplayName("Obtener promedio de un estudiante existente")
    void analyzeScoresOK() {
        // Arrange
        StudentDTO stu = StudentFactory.createJuan();

        // MOCK
        Mockito.when(this.service.analyzeScores(stu.getId())).thenReturn(stu);

        // Act
        StudentDTO result = this.controller.analyzeScores(stu.getId());

        // Assert
        Assertions.assertEquals(stu, result);
    }


    @Test
    @DisplayName("Obtener promedio del estudiante - ObtenerDiplomaException")
    void analyzeScores(){
        // Arrange
        StudentDTO stu = StudentFactory.createJuan();

        // MOCK
        Mockito.when(this.service.analyzeScores(stu.getId()))
                .thenThrow(new ObtenerDiplomaException("ObtenerDiplomaException", HttpStatus.BAD_REQUEST));

        // Assert
        Assertions.assertThrows(ObtenerDiplomaException.class, () -> this.controller.analyzeScores(stu.getId()));

    }
}
