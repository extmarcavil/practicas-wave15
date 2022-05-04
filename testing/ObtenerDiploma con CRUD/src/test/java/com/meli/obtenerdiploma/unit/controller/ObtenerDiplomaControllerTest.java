package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("Obtener promedio del estudiante - Id OK")
    void analyzeScoresOK(){
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

        // When + Then
        Assertions.assertThrows(ObtenerDiplomaException.class, () -> this.controller.analyzeScores(stu.getId()));
    }
}
