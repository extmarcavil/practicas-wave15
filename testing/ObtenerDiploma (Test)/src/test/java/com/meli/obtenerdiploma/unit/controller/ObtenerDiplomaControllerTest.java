package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("Get the scores of a student")
    public void analyzeScores() {
        // Arrange
        StudentDTO expected = StudentFactory.studentJuanWithScores();

        // Mock
        when(service.analyzeScores(expected.getId())).thenReturn(expected);

        // Act
        StudentDTO result = controller.analyzeScores(expected.getId());

        // Assert
        assertAll(
                () -> assertEquals(expected, result),
                () -> verify(service, times(1)).analyzeScores(expected.getId())
        );
    }
}
