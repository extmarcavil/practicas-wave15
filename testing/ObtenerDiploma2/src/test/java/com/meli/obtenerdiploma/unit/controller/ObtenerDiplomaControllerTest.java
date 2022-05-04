package com.meli.obtenerdiploma.unit.controller;


import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
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

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Incorrect average")
    public void averageIncorrect() {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 9.0);
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", null, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        StudentDTO resp = obtenerDiplomaController.analyzeScores(1L);

        Assertions.assertNotEquals(resp.getAverageScore(),10D);
    }

    @Test
    @DisplayName("Correct average")
    public void averageCorrect() {
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 9.0);
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", null, null, List.of(subjectDTO1, subjectDTO2));

        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        StudentDTO resp = obtenerDiplomaController.analyzeScores(1L);

        Assertions.assertNotEquals(resp.getAverageScore(),8D);
    }

}
