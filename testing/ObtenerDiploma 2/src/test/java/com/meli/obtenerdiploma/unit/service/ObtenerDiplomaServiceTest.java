package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.StudentsFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Correcto calculo del promedio de notas de un estudiante")
    public void analyzeScoresWithCorrectData() {
        // arrange
        Long validId = 2L;
        Double expectedAverage = 7.33D;
        StudentDTO student = StudentsFactory.getStudent();
        DecimalFormat df = new DecimalFormat("0.00");

        // Mockito
        Mockito.when(studentDAO.findById(validId)).thenReturn(student);

        // act
        StudentDTO resultStudent = obtenerDiplomaService.analyzeScores(validId);

        // assert
        Assertions.assertEquals(expectedAverage, Double.parseDouble(df.format(resultStudent.getAverageScore())));
    }

    @Test
    @DisplayName("Verificacion de mensaje de diploma")
    public void verifyDiplomaMessage() {
        // arrange
        Long validId = 2L;
        Double expectedAverage = 7.33D;
        StudentDTO student = StudentsFactory.getStudent();
        DecimalFormat df = new DecimalFormat("0.00");
        String expectedMessage = StudentsFactory.getDiplomaMessage(student.getStudentName(), expectedAverage);

        // Mockito
        Mockito.when(studentDAO.findById(validId)).thenReturn(student);

        // act
        StudentDTO resultStudent = obtenerDiplomaService.analyzeScores(validId);

        // assert
        Assertions.assertEquals(expectedMessage, resultStudent.getMessage());
    }

    @Test
    @DisplayName("Verificacion de mensaje de diploma con honores")
    public void verifyDiplomaMessageWithHonors() {
        // arrange
        Long validId = 4L;
        Double expectedAverage = 10.00D;
        StudentDTO student = StudentsFactory.getStudentWithHonors();
        DecimalFormat df = new DecimalFormat("0.00");
        String expectedMessage = StudentsFactory.getDiplomaMessageWithHonors(student.getStudentName(), expectedAverage);

        // Mockito
        Mockito.when(studentDAO.findById(validId)).thenReturn(student);

        // act
        StudentDTO resultStudent = obtenerDiplomaService.analyzeScores(validId);

        // assert
        Assertions.assertEquals(expectedMessage, resultStudent.getMessage());
    }
}
