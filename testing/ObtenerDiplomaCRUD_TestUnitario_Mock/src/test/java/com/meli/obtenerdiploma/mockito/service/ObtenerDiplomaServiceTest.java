package com.meli.obtenerdiploma.mockito.service;

import com.meli.obtenerdiploma.dao.IStudentDAO;
import com.meli.obtenerdiploma.dao.StudentDAO;
import com.meli.obtenerdiploma.dao.model.StudentDTO;
import com.meli.obtenerdiploma.dao.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {


    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;



    @Test
    @DisplayName("No encuentra el estudiante")
    void averageTestNotFound(){

        Assertions.assertThrows(NullPointerException.class , () -> obtenerDiplomaService.analyzeScores(4L)); ;
    }

    @Test
    @DisplayName("Calculo que el average sea igual al que envio con la diferencia de que el que se calcula debe ser igual al que indico")
    void averageTestCorrect(){

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2l);
        studentDTO.setStudentName("Pedro");
        List<SubjectDTO> subjectDTOS1 = new ArrayList<>();
        subjectDTOS1.add(new SubjectDTO("Matematica", 10D));
        subjectDTOS1.add(new SubjectDTO("Fisica", 10D));
        subjectDTOS1.add(new SubjectDTO("Quimica", 10D));
        studentDTO.setSubjects(subjectDTOS1);


        Mockito.when(studentDAO.findById(2l)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(2l);

        Assertions.assertEquals(10.0, result.getAverageScore());

    }

    @Test
    @DisplayName("Los mensajes deben ser identicos")
    void messageTestCorrect(){

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2l);
        studentDTO.setStudentName("Pedro");
        List<SubjectDTO> subjectDTOS1 = new ArrayList<>();
        subjectDTOS1.add(new SubjectDTO("Matematica", 10D));
        subjectDTOS1.add(new SubjectDTO("Fisica", 10D));
        subjectDTOS1.add(new SubjectDTO("Quimica", 10D));
        studentDTO.setSubjects(subjectDTOS1);


        Mockito.when(studentDAO.findById(2l)).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(2l);

        String message = "El alumno Pedro ha obtenido un promedio de 10. Felicitaciones!";

        Assertions.assertEquals(message, result.getMessage());

    }

    @Test
    @DisplayName("Envio un identificador invalido al que calculo su promedio")
    void averageTestNotValid(){

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2l);
        studentDTO.setStudentName("Pedro");
        List<SubjectDTO> subjectDTOS1 = new ArrayList<>();
        subjectDTOS1.add(new SubjectDTO("Matematica", 10D));
        subjectDTOS1.add(new SubjectDTO("Fisica", 10D));
        subjectDTOS1.add(new SubjectDTO("Quimica", 10D));
        studentDTO.setSubjects(subjectDTOS1);


        Mockito.when(studentDAO.findById(2l)).thenReturn(studentDTO);

        Assertions.assertThrows(org.mockito.exceptions.misusing.PotentialStubbingProblem.class, () -> obtenerDiplomaService.analyzeScores(1l));

    }

}
