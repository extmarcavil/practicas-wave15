package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ExtendWith(MockitoExtension.class)
public class TestObtenerDiplomaController {

    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void test_analyzeScoresOfStudent1() {
        // Given
        Long id = 50L;
        StudentDTO s = StudentFactory.createStraightAStudent();
        s.setId(id);
        Mockito.when(obtenerDiplomaService.analyzeScores(id)).thenReturn(s);

        // When
        StudentDTO result = obtenerDiplomaController.analyzeScores(id);

        // Then
        Assertions.assertEquals(s, result);
    }

    @Test
    public void test_analyzeScoresOfStudent2() {
        // Given
        Long id = 50L;
        StudentDTO s = StudentFactory.createStraightAStudent();
        s.setId(id);
        Mockito
                .when(obtenerDiplomaService.analyzeScores(id))
                .thenThrow(new ObtenerDiplomaException("msg", HttpStatus.BAD_REQUEST));

        // When + Then
        Assertions.assertThrows(ObtenerDiplomaException.class, () -> obtenerDiplomaController.analyzeScores(id));
    }

    @Test
    public void test_analyzeScoresOfStudent4() {
        // Given
        Long id = 50L;
        StudentDTO s = StudentFactory.createStraightAStudent();
        s.setId(id);
        Mockito
                .when(obtenerDiplomaService.analyzeScores(id))
                .thenThrow(new HttpMessageNotReadableException("msg"));

        // When + Then
        Assertions.assertThrows(HttpMessageNotReadableException.class, () -> obtenerDiplomaController.analyzeScores(id));
    }

}
