package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    ObtenerDiplomaService mockObtenerService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName(" Comprobar que el estudiante tiene average y message agregado")
    void analyzeScore(){
        //Arrange
        StudentDTO studentDTO = StudentFactory.getStudentJuanInJson();
        Long id = studentDTO.getId();
        // Mock
        when(mockObtenerService.analyzeScores(id)).thenReturn(studentDTO);
        //Act
        StudentDTO  result = obtenerDiplomaController.analyzeScores(id);
        //Assert
        assertAll(
                () -> assertEquals(studentDTO,result),
                () -> assertFalse(result.getAverageScore().isNaN()),
                () -> assertFalse(result.getMessage().isEmpty())

        );

    }
}
