package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private IObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScores_existingStudent() {
        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Historia", 9.5D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 6.5D);
        Long studentId = 2L;
        Double expectedScore = 8D;
        StudentDTO student = new StudentDTO(studentId, "test", null, null, List.of(subject1, subject2));
        // Act
        Mockito.when(studentDAO.findById(Mockito.any(Long.class))).thenReturn(student);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);
        // Assert
        Assertions.assertEquals(expectedScore, result.getAverageScore());
    }
}
