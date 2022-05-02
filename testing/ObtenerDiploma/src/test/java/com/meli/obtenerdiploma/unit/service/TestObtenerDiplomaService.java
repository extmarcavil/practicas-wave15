package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestObtenerDiplomaService {

    private ObtenerDiplomaService obtenerDiplomaService;

    @Mock
    private IStudentDAO studentDAO;

    @BeforeEach
    public void initialize() {
        this.obtenerDiplomaService = new ObtenerDiplomaService(this.studentDAO);
    }

    @Test
    @DisplayName("Analizar las notas de un alumno que tenga todo 10")
    public void test_analyzeScoresOfAStraightAStudent() {
        // Given
        Long id = 1L;
        StudentDTO student = StudentFactory.createStraightAStudent();
        Mockito.when(studentDAO.findById(id)).thenReturn(student);

        // When
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);

        // Then
        Assertions.assertEquals(10D, result.getAverageScore());
    }

    @Test
    @DisplayName("Analizar el mensaje de un alumno que tenga todo 10")
    public void test_analyzeMessageOfAStraightAStudent() {
        // Given
        Long id = 1L;
        StudentDTO student = StudentFactory.createStraightAStudent();
        Mockito.when(studentDAO.findById(id)).thenReturn(student);

        // When
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);

        // Then
        Assertions.assertTrue(result.getMessage().contains("Felicitaciones"));
    }

    @Test
    @DisplayName("Analizar las notas de un alumno que tenga todo 10")
    public void test_analyzeScoresOfALazyStudent() {
        // Given
        Long id = 1L;
        StudentDTO student = StudentFactory.createLazyStudent();
        Mockito.when(studentDAO.findById(id)).thenReturn(student);

        // When
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);

        // Then
        Assertions.assertEquals(7D, result.getAverageScore());
    }

    @Test
    @DisplayName("Analizar el mensaje de un alumno que tenga todo 10")
    public void test_analyzeMessageOfALazyStudent() {
        // Given
        Long id = 1L;
        StudentDTO student = StudentFactory.createLazyStudent();
        Mockito.when(studentDAO.findById(id)).thenReturn(student);

        // When
        StudentDTO result = obtenerDiplomaService.analyzeScores(id);

        // Then
        Assertions.assertTrue(result.getMessage().contains("Puedes mejorar"));
    }
}
