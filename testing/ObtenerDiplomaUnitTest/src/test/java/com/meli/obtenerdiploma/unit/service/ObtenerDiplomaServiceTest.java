package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.StudentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO mockStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName(" Comprobar el correcto calculo de average")
    void analyzeAverageScore(){
        //Arrange
        double averageScoreExpected = 9;
        StudentDTO studentDTO = StudentFactory.createStudentOne();
        // Mock
        when(mockStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        //Act
        StudentDTO  result = obtenerDiplomaService.analyzeScores(studentDTO.getId());
        //Assert
        assertEquals(averageScoreExpected, result.getAverageScore());
    }

    @Test
    @DisplayName(" Comprobar el correcto mensaje para promedio igual a 9")
    void analyzeAverageMessageEqualToNine(){
        //Arrange
        double average = 9;
        StudentDTO studentDTO = StudentFactory.createStudentOne();
        String messageExpected = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Puedes mejorar.";
        // Mock
        when(mockStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        //Act
        StudentDTO  result = obtenerDiplomaService.analyzeScores(studentDTO.getId());
        //Assert
        assertEquals(messageExpected, result.getMessage());
    }

    @Test
    @DisplayName(" Comprobar el correcto mensaje para promedio menor a 9")
    void analyzeAverageMessageLessThanNine(){
        //Arrange
        double average = 7;
        StudentDTO studentDTO = StudentFactory.createStudentTwo();
        String messageExpected = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Puedes mejorar.";

        // Mock
        when(mockStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        //Act
        StudentDTO  result = obtenerDiplomaService.analyzeScores(studentDTO.getId());
        //Assert
        assertEquals(messageExpected, result.getMessage());
    }


    @Test
    @DisplayName(" Comprobar el correcto mensaje para promedio mayor a 9")
    void analyzeAverageMessageGreaterThanNine(){
        //Arrange
        double average = 10;
        StudentDTO studentDTO = StudentFactory.createStudentThree();
        String messageExpected = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Felicitaciones!";

        // Mock
        when(mockStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        //Act
        StudentDTO  result = obtenerDiplomaService.analyzeScores(studentDTO.getId());
        //Assert
        assertEquals(messageExpected, result.getMessage());
    }


}
