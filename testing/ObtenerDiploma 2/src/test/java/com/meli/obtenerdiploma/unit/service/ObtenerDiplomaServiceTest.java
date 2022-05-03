package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
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

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Mensaje correcto")
    public void messageSuccessfully(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 9.0);
        String message = "El alumno " + "Jose" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(8.0)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", null, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        Assertions.assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("Mensaje correcto - Exelente")
    public void messageExellentSuccessfully(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10.0);
        String message = "El alumno " + "Jose" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(10.0)
                + ". Felicitaciones!";
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", null, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        Assertions.assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("Mensaje incorrecto - Felicidades!")
    public void messageNotEquals(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10.0);
        String message = "El alumno " + "Jose" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(10.0)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", null, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        Assertions.assertNotEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("Calcular el promedio correcto")
    public void calculateAverageCorrect(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 9.0);
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", null, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        Assertions.assertEquals(result.getAverageScore(), 8.0);
    }
}
