package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DecimalFormat;
import java.util.List;;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoreController(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 8d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10d);
        String message = "El alumno " + "Test" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(9D)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Test", message, 9d, List.of(subjectDTO1, subjectDTO2));

        when(obtenerDiplomaService.analyzeScores(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);

        //assert


        assertAll(
                () -> verify(obtenerDiplomaService, Mockito.times(1)).analyzeScores(any(Long.class)),
                () -> assertEquals(result.getAverageScore(), studentDTO.getAverageScore()),
                () -> assertEquals(result.getStudentName(), studentDTO.getStudentName()),
                () -> assertEquals(result.getMessage(), message),
                () -> assertEquals(result.getId(), studentDTO.getId()),
                () -> assertEquals(result.getSubjects().size(), studentDTO.getSubjects().size()),
                () -> {
                    for (SubjectDTO s: result.getSubjects()) {
                        assertTrue(studentDTO.getSubjects().contains(s));
                    }
                }
        );
    }

    @Test
    public void analyzeExcellentScoreController(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 10d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10d);
        String message = "El alumno " + "Test" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(10D)
                + ". Felicitaciones!";
        StudentDTO studentDTO = new StudentDTO(1L, "Test", message, 10d, List.of(subjectDTO1, subjectDTO2));

        when(obtenerDiplomaService.analyzeScores(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);

        //assert
        assertAll(
                () -> verify(obtenerDiplomaService, Mockito.times(1)).analyzeScores(any(Long.class)),
                () -> assertEquals(result.getAverageScore(), studentDTO.getAverageScore()),
                () -> assertEquals(result.getStudentName(), studentDTO.getStudentName()),
                () -> assertEquals(result.getMessage(), message),
                () -> assertEquals(result.getId(), studentDTO.getId()),
                () -> assertEquals(result.getSubjects().size(), studentDTO.getSubjects().size()),
                () -> {
                    for (SubjectDTO s: result.getSubjects()) {
                        assertTrue(studentDTO.getSubjects().contains(s));
                    }
                }
        );
    }

    @Test
    public void analyzeScoreNotExistentStudent(){
        //arrange

        when(obtenerDiplomaService.analyzeScores(any(Long.class))).thenThrow(StudentNotFoundException.class);

        //act

        //assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(1L));
        verify(obtenerDiplomaService, Mockito.times(1)).analyzeScores(any(Long.class));
    }

}
