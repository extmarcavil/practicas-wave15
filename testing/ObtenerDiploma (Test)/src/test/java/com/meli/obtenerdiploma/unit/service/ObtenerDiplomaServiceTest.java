package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO repository;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    @DisplayName("Check the correct calculation of average score")
    public void checkCorrectAverageScore() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expected = StudentFactory.studentJuanWithScores();

        // Act and Mock
        when(repository.findById(studentId)).thenReturn(StudentFactory.studentJuan());
        StudentDTO result = diplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(expected.getAverageScore(), result.getAverageScore(),
                "The average scores are different");
    }

    @Test
    @DisplayName("Check the correct calculation of greeting message")
    public void checkCorrectGreetingMessage() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expected = StudentFactory.studentJuanWithScores();

        // Act and Mock
        when(repository.findById(studentId)).thenReturn(StudentFactory.studentJuan());
        StudentDTO result = diplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(expected.getMessage(), result.getMessage(), "The messages are different");
    }

    @Test
    @DisplayName("Check that an exception is thwrown when a student is not found")
    public void analyzeScoresNull() {
        // Arrange
        Long studentId = null;

        // Mock
        when(repository.findById(studentId)).thenThrow(StudentNotFoundException.class);

        // Assert
        assertThrows(StudentNotFoundException.class, () -> diplomaService.analyzeScores(studentId),
                "The average scores are differents");
    }


}
