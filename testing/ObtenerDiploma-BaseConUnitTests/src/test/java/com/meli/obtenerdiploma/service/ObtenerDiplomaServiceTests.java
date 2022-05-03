package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void averageScoreWellCalculated() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(6.0, stu.getAverageScore());
    }

    @Test
    public void averageScoreOver9MessageWellWritten() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 9.00. Felicitaciones!", stu.getMessage());
    }

    @Test
    public void averageScoreBelow9MessageWellWritten() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 6.00. Puedes mejorar.", stu.getMessage());
    }

    @Test
    public void RequestStudentNameMatchesResponseStudentName() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("Marco", stu.getStudentName());
    }

    @Test
    public void RequestStudentSubjectListMatchesResponseSubjectList() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        List<SubjectDTO> initalList = new ArrayList<>();
        stu.getSubjects().stream().forEach((s) -> initalList.add(SerializationUtils.clone(s)));

        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertTrue(CollectionUtils.isEqualCollection(initalList, stu.getSubjects()));
    }
}
