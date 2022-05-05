package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
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
    void analyzeScoresStudentNull(){

        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenThrow(StudentNotFoundException.class);

        StudentNotFoundException result = Assertions.assertThrows(StudentNotFoundException.class,
                () -> obtenerDiplomaService.analyzeScores(Mockito.anyLong()));

        Assertions.assertEquals(result.getClass(), StudentNotFoundException.class);
    }

    @Test
    void analyzeScoresAvarage(){
        StudentDTO student = new StudentDTO();
        student.setStudentName("Mario");
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(new SubjectDTO("Filosofía", 6.0));
        materias.add(new SubjectDTO("Dibujo", 6.0));
        student.setSubjects(materias);
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenReturn(student);

        Double expectedScore = 6D;

        StudentDTO studentScore = obtenerDiplomaService.analyzeScores(Mockito.anyLong());
        Assertions.assertEquals(expectedScore, studentScore.getAverageScore());
    }

    @Test
    void analyzeScoresMessage(){
        StudentDTO student = new StudentDTO();
        student.setStudentName("Mario");
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(new SubjectDTO("Filosofía", 6.0));
        materias.add(new SubjectDTO("Dibujo", 6.0));
        student.setSubjects(materias);
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenReturn(student);

        String expectedMessge = "El alumno Mario ha obtenido un promedio de 6. Puedes mejorar.";
        StudentDTO studentScore = obtenerDiplomaService.analyzeScores(Mockito.anyLong());
        Assertions.assertEquals(expectedMessge, studentScore.getMessage());
    }

    @Test
    void analyzeScoresMessageWithHonor(){
        StudentDTO student = new StudentDTO();
        student.setStudentName("Mario");
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(new SubjectDTO("Filosofía", 12.0));
        materias.add(new SubjectDTO("Dibujo", 12.0));
        student.setSubjects(materias);
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenReturn(student);

        String expectedMessge = "El alumno Mario ha obtenido un promedio de 12. Felicitaciones!";
        StudentDTO studentScore = obtenerDiplomaService.analyzeScores(Mockito.anyLong());
        Assertions.assertEquals(expectedMessge, studentScore.getMessage());
    }

}
