package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDao;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaServiceImpl;

    //Student
    StudentDTO s;
    StudentDTO s1;

    @BeforeEach
    void setUp() {
        //Students
        SubjectDTO subject = new SubjectDTO("Calculo", 5.0);
        SubjectDTO subject1 = new SubjectDTO("Fisica", 10.0);
        s = new StudentDTO();
        s.setStudentName("Javier");
        s.setSubjects(Arrays.asList(subject, subject1));

        SubjectDTO subj = new SubjectDTO("Calculo", 10.0);
        SubjectDTO subj1 = new SubjectDTO("Fisica", 10.0);
        s1 = new StudentDTO();
        s1.setStudentName("Ricardo");
        s1.setSubjects(Arrays.asList(subj, subj1));
    }

    /**
     * Analizando las notas de un estudiante.
     */
    @DisplayName("Analizando las notas de un estudiante")
    @Test
    void analyzeScoresTest() {
        //Arrange
        when(studentDao.findById(anyLong())).thenReturn(s);

        //Act
        StudentDTO stu = obtenerDiplomaServiceImpl.analyzeScores(10L);

        //Assert
        assertAll(
                () -> assertEquals("Javier", stu.getStudentName(), "El nombre no coincide con el estudiante buscado"),
                () -> assertEquals(7.5, stu.getAverageScore()),
                () -> assertEquals("El alumno Javier ha obtenido un promedio de 7.5. Puedes mejorar.", stu.getMessage()),
                () -> assertEquals(2, stu.getSubjects().size())
        );
        verify(studentDao, atLeastOnce()).findById(any());
    }

    /**
     * Analizando las notas de un estudiante.
     */
    @DisplayName("Analizando las notas de un estudiante")
    @Test
    void analyzeScores1Test() {
        //Arrange
        when(studentDao.findById(anyLong())).thenReturn(s1);

        //Act
        StudentDTO stu = obtenerDiplomaServiceImpl.analyzeScores(20L);

        //Assert
        assertAll(
                () -> assertEquals("Ricardo", stu.getStudentName()),
                () -> assertEquals(10.0, stu.getAverageScore()),
                () -> assertEquals("El alumno Ricardo ha obtenido un promedio de 10. Felicitaciones!", stu.getMessage()),
                () -> assertEquals(2, stu.getSubjects().size())
        );
        verify(studentDao, atLeastOnce()).findById(20L);
    }


}