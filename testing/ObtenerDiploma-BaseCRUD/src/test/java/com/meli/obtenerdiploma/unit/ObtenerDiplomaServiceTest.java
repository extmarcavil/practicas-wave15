package com.meli.obtenerdiploma.unit;

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
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverage(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 8d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10d);
        StudentDTO studentDTO = new StudentDTO(1L, "Test", null, null, List.of(subjectDTO1, subjectDTO2));

        when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(result.getAverageScore(), 9D);
    }

    @Test
    public void entryEqualsExit(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 8d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10d);
        String message = "El alumno " + "Test" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(9D)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Test", message, 9D, List.of(subjectDTO1, subjectDTO2));

        when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertAll(
                () -> assertEquals(result.getAverageScore(), studentDTO.getAverageScore()),
                () -> assertEquals(result.getStudentName(), studentDTO.getStudentName()),
                () -> assertEquals(result.getMessage(), studentDTO.getMessage()),
                () -> assertEquals(result.getId(), studentDTO.getId()),
                () -> assertEquals(result.getSubjects().size(), studentDTO.getSubjects().size()),
                () -> {
                    for (SubjectDTO s : result.getSubjects()) {
                        Assertions.assertTrue(studentDTO.getSubjects().contains(s));
                    }
                }
        );
    }

    @Test
    public void showLegendSuccessfully(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 8d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 8d);
        String message = "El alumno " + "Test" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(8D)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Test", null, null, List.of(subjectDTO1, subjectDTO2));

        when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("Borde: Mostrar el mensaje de 'puedes mejorar' por un promedio de 9")
    public void showLegendSuccessfullyBorder(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 8d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10d);
        String message = "El alumno " + "Test" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(9D)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Test", null, null, List.of(subjectDTO1, subjectDTO2));

        when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(message, result.getMessage());
    }

    @Test
    public void showLegendExcellentSuccessfully(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10d);
        String message = "El alumno " + "Test" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(9.5D)
                + ". Felicitaciones!";
        StudentDTO studentDTO = new StudentDTO(1L, "Test", null, null, List.of(subjectDTO1, subjectDTO2));

        when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("Borde: Mostrar el mensaje de felicitacion por un promedio de 9.05")
    public void showLegendExcellentBorderSuccessfully(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 9.1d);
        String message = "El alumno " + "Test" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(9.05D)
                + ". Felicitaciones!";
        StudentDTO studentDTO = new StudentDTO(1L, "Test", null, null, List.of(subjectDTO1, subjectDTO2));

        when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(message, result.getMessage());
    }

    @Test
    public void showLegendWrongly(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Historia", 9d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 10d);
        String message = "El alumno " + "Test" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(9D)
                + ". Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Test", null, null, List.of(subjectDTO1, subjectDTO2));

        when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertNotEquals(message, result.getMessage());
    }
}
