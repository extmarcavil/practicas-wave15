package com.meli.obtenerdiploma.unit.controller;


import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analizar un promedio con mensaje correcto")
    void analyzeScoreCorrect(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 9.0);
        String message = "El alumno " + "Jose" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(8.0)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", message, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);

        //assert
        Mockito.verify(obtenerDiplomaService, Mockito.times(1)).analyzeScores(1L);
        Assertions.assertEquals(message, result.getMessage());

    }

    @Test
    @DisplayName("Analizar un promedio con mensaje correcto - excelente")
    void analyzeScoreCorrectExcellent(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10.0);
        String message = "El alumno " + "Jose" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(10.0)
                + ". Felicitaciones!";
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", message, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);

        //assert
        Mockito.verify(obtenerDiplomaService, Mockito.times(1)).analyzeScores(1L);
        Assertions.assertEquals(message, result.getMessage());

    }

    @Test
    @DisplayName("Mensaje incorrecto - Felicidades!")
    void analyzeScoreCorrectExcellentIncorrect(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10.0);
        String message = "El alumno " + "Jose" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(10.0)
                + ". Puedes mejorar.";
        String message2 = "El alumno " + "Jose" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(10.0)
                + ". Felicitaciones!";

        StudentDTO studentDTO = new StudentDTO(1L, "Jose", message2, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);

        //assert
        Mockito.verify(obtenerDiplomaService, Mockito.times(1)).analyzeScores(1L);
        Assertions.assertNotEquals(message, result.getMessage());

    }

    @Test
    @DisplayName("Analizar promedio con ID incorrecto")
    public void analyzeScoreIncorrectIDStudent(){
        //arrange

        Mockito.when(obtenerDiplomaService.analyzeScores(3L)).thenThrow(StudentNotFoundException.class);

        //act & assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(3L));

    }



}
